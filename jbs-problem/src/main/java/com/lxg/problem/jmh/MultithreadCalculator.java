package com.lxg.problem.jmh;

import com.lxg.common.thread.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * MultithreadCalculator
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/21
 * @since 1.8
 **/
public class MultithreadCalculator implements Calculator {
    private final int nThreads;
    private final ExecutorService pool;

    public MultithreadCalculator(int nThreads) {
        this.nThreads = nThreads;
        ThreadFactory nameThreadFactory = new NamedThreadFactory("multi-thread-calculator");
        this.pool = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),nameThreadFactory);
    }

    private class SumTask implements Callable<Long> {
        private int[] numbers;
        private int from;
        private int to;

        public SumTask(int[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long total = 0L;
            for (int i = from; i < to; i++) {
                total += numbers[i];
            }
            return total;
        }
    }

    @Override
    public long sum(int[] numbers) {
        int chunk = numbers.length / nThreads;

        int from, to;
        List<SumTask> tasks = new ArrayList<SumTask>();
        for (int i = 1; i <= nThreads; i++) {
            if (i == nThreads) {
                from = (i - 1) * chunk;
                to = numbers.length;
            } else {
                from = (i - 1) * chunk;
                to = i * chunk;
            }
            tasks.add(new SumTask(numbers, from, to));
        }

        try {
            List<Future<Long>> futures = pool.invokeAll(tasks);

            long total = 0L;
            for (Future<Long> future : futures) {
                total += future.get();
            }
            return total;
        } catch (Exception e) {
            // ignore
            return 0;
        }
    }

    @Override
    public void shutdown() {
        pool.shutdown();
    }
}
