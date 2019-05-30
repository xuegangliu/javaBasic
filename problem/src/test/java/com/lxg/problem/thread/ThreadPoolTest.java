package com.lxg.problem.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**************************
 * @description: ThreadPoolTest
 * @author: xuegangliu
 * @date: 2019/3/19 17:40
 ***************************/
@Slf4j
public class ThreadPoolTest {

    @Test
    public void testSingleThread() throws InterruptedException {
        ExecutorService executor = SelfThreadPool.singleThreadExecutor;

        for(int i=0;i<20;i++){
            Thread1 t1 = new Thread1("thread"+i);
            executor.execute(t1);
        }
        Thread.sleep(5*6000);
    }

    @Test
    public void testCachedThread() throws InterruptedException {
        ExecutorService executor = SelfThreadPool.cachedThreadPool;

        for(int i=0;i<20;i++){
            Thread1 t1 = new Thread1("thread"+i);
            executor.execute(t1);
        }
        Thread.sleep(5*6000);
    }

    @Test
    public void testFixedThread() throws InterruptedException {
        ExecutorService executor = SelfThreadPool.fixedThreadPool;

        for(int i=0;i<20;i++){
            Thread1 t1 = new Thread1("thread"+i);
            executor.execute(t1);
        }
        Thread.sleep(5*6000);
    }

    @Test
    public void testSelfThreadPool() throws IOException {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new SelfThreadPool.NameTreadFactory();
        RejectedExecutionHandler handler = new SelfThreadPool.MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        executor.prestartAllCoreThreads(); // 预启动所有核心线程

        for (int i = 1; i <= 10; i++) {
            SelfThreadPool.MyTask task = new SelfThreadPool.MyTask(String.valueOf(i));
            executor.execute(task);
        }
        //阻塞主线程
//        System.in.read();
    }
}

