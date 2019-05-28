package com.lxg.problem.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: ThreadTest
 * @author: xuegangliu
 * @date: 2019/3/4 10:10
 ***************************/
@Slf4j
public class ThreadTest {

    @Test
    public void testUnSecurity(){
        ThreadUnSecurity.SellTickets sell = new ThreadUnSecurity().new SellTickets();
        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    @Test
    public void testSecurityOne(){
        ThreadUnSecurity.SellTicketsSecurity sell = new ThreadUnSecurity().new SellTicketsSecurity();
        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    @Test
    public void testSecurityTwo(){
        ThreadUnSecurity.SellTicketsSecurity2 sell = new ThreadUnSecurity().new SellTicketsSecurity2();
        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    @Test
    public void testSecurityThree(){
        ThreadUnSecurity.SellTicketsSecurity3 sell = new ThreadUnSecurity().new SellTicketsSecurity3();
        Thread thread1 = new Thread(sell, "1号窗口");
        Thread thread2 = new Thread(sell, "2号窗口");
        Thread thread3 = new Thread(sell, "3号窗口");
        Thread thread4 = new Thread(sell, "4号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    @Test
    public void testDemo(){
        new Thread(new ThreadDemo.ThreadA()).start();
        new Thread(new ThreadDemo.ThreadB()).start();
    }

    @Test
    public void test1(){
        log.info("{},{}",1,2);
    }

    /**
     * interrupt()示例
     */
    @Test
    public void testSample1(){
        Sample1 t = new Sample1();
        log.info("Start thread");
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("...........");
        t.stop=true;// 结束终止
        t.interrupt();// 设置中断信号,提前终结自己的阻塞状态
    }

    /**
     * yield()/join()使用
     */
    @Test
    public void testSample2(){
        Sample2 sample2 = new Sample2();
        sample2.start();
        log.info("yield() start");
//        Thread.yield();// 不能由用户指定暂停多长时间
        log.info("yield() end");
//        log.info("{}",sample2.isInterrupted());
        try {
//            sample2.join(); //等待线程执行完毕后,处理下边的程序
//            Thread.sleep(2000);
//            log.info("wait start...");
            synchronized (sample2) {
                sample2.wait(5000);// 线程操作的wait()、notify()、notifyAll()方法只能在同步控制方法或同步控制块内调用
            }
//            log.info("{}",sample2.isAlive());
            log.info("wait end...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSample3() throws InterruptedException{
        Sample3 s3= new Sample3();
        Thread b = new Thread(s3);
        log.info("start before b={}",s3.b);
        b.start();// 可能先执行,可能后执行
        Thread.sleep(2000);
        log.info("start running,b={}",s3.b);
        s3.s2();
        log.info("end,Sample3.b={}",s3.b);
    }
}

@Slf4j
class Sample1 extends Thread{
    volatile boolean stop = false; // 结束开关
    public void run() {
        while (!stop){
            log.info("Running is start...");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Running is end ...");
    }
    /*当代码调用中须要抛出一个InterruptedException, 你可以选择把中断状态复位, 也可以选择向外抛出InterruptedException, 由外层的调用者来决定。
    不是所有的阻塞方法收到中断后都可以取消阻塞状态, 输入和输出流类会阻塞等待 I/O 完成，但是它们不抛出 InterruptedException，而且在被中断的情况下也不会退出阻塞状态。
    尝试获取一个内部锁的操作（进入一个 synchronized 块）是不能被中断的*/
}

@Slf4j
class Sample2 extends Thread{

    public void run(){
        log.info("Sample2 run ...");
        try {
            Thread.sleep(2000);
            log.info("Sample2 running is start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Sample2 running is end");
    }
}

@Slf4j
class Sample3 implements Runnable{

    int b = 50;

    /**
     * 对象锁
     * @throws InterruptedException
     */
    synchronized void s1() throws InterruptedException{
        b = 100;
    }

    /**
     * 对象锁
     * @throws InterruptedException
     */
    synchronized void s2() throws InterruptedException{
        b = 200;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            s1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}