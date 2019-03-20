package com.lxg.problem.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;

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
}

