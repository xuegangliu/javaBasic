package com.lxg.problem.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**************************
 *  SelfThreadPool
 * @author xuegangliu
 *  2019/3/19 17:34
 ***************************/
public final class SelfThreadPool {

    private static Integer core = Runtime.getRuntime().availableProcessors();

    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();
    /**
     * corePoolSize = 0，maximumPoolSize = Integer.MAX_VALUE，即线程数量几乎无限制；
     * keepAliveTime = 60s，线程空闲60s后自动结束。
     * workQueue 为 SynchronousQueue 同步队列，这个队列类似于一个接力棒，入队出队必须同时传递，
     * 因为CachedThreadPool线程创建无限制，不会有队列等待，所以使用SynchronousQueue；
     */
    public static ExecutorService cachedThreadPool = new ThreadPoolExecutor(
            0,
            Integer.MAX_VALUE,
            60L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            threadFactory
    );

    /**
     * corePoolSize与maximumPoolSize相等，即其线程全为核心线程，是一个固定大小的线程池，是其优势；
     * keepAliveTime = 0 该参数默认对核心线程无效，而FixedThreadPool全部为核心线程；
     * workQueue 为LinkedBlockingQueue（无界阻塞队列），队列最大值为Integer.MAX_VALUE。
     * 如果任务提交速度持续大余任务处理速度，会造成队列大量阻塞。因为队列很大，很有可能在拒绝策略前，内存溢出。是其劣势；
     * FixedThreadPool的任务执行是无序的；
     *
     */
    public static ExecutorService fixedThreadPool = new ThreadPoolExecutor(
            5,
            5,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            threadFactory
    );

    /**
     * FixedThreadPool可以向下转型为ThreadPoolExecutor
     * Executors利用FinalizableDelegatedExecutorService包装,无法修改，做到了真正的Single
     */
    public static ExecutorService singleThreadExecutor = new ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            threadFactory
    );

    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }
        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            System.err.println( r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }

    static class MyTask implements Runnable {
        private String name;
        public MyTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                // 让任务执行慢点
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }
}
