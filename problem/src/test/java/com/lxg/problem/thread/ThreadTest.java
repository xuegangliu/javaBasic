package com.lxg.problem.thread;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

/**************************
 * @description: ThreadTest
 * @author: xuegangliu
 * @date: 2019/3/4 10:10
 ***************************/
@Log4j2
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
}
