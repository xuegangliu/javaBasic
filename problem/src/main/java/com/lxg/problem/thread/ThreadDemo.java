package com.lxg.problem.thread;

import lombok.extern.slf4j.Slf4j;

/**************************
 * @description: ThreadDemo
 * @author: xuegangliu
 * @date: 2019/3/4 11:32
 ***************************/
@Slf4j
public class ThreadDemo {

    static final Object OBJ = new Object();

    /**
     * 第一个子线程
     */
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (ThreadDemo.OBJ) {
                    log.info("Aa-----" + count);
                    count--;
                    synchronized (ThreadDemo.OBJ) {
                        //notify()方法会唤醒因为调用对象的wait()而处于等待状态的线程，从而使得该线程有机会获取对象锁。
                        //调用notify()后，当前线程并不会立即释放锁，而是继续执行当前代码，直到synchronized中的代码全部执行完毕，
                        ThreadDemo.OBJ.notify();
                        try {
                            ThreadDemo.OBJ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (ThreadDemo.OBJ) {
                    log.info("Bb-----" + count);
                    count--;
                    synchronized (ThreadDemo.OBJ) {
                        //notify()方法会唤醒因为调用对象的wait()而处于等待状态的线程，从而使得该线程有机会获取对象锁。
                        //调用notify()后，当前线程并不会立即释放锁，而是继续执行当前代码，直到synchronized中的代码全部执行完毕，
                        ThreadDemo.OBJ.notify();
                        try {
                            ThreadDemo.OBJ.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
