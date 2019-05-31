package com.lxg.problem.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**************************
 *  ThreadUnSecurity
 * @author xuegangliu
 *  2019/3/4 10:07
 ***************************/
@Slf4j
public class ThreadUnSecurity {
    static int tickets = 10;

    class SellTickets implements Runnable{
        @Override
        public void run() {
            // 未加同步时产生脏数据
            while(tickets > 0) {
                log.info(Thread.currentThread().getName()+"--->售出第：  "+tickets+" 票");
                tickets--;
            }
            if (tickets <= 0) {
                log.info(Thread.currentThread().getName()+"--->售票结束！");
            }
        }
    }

    /**
     * 同步代码块
     */
    class SellTicketsSecurity implements Runnable{
        @Override
        public void run() {
            // 同步代码块 (将售票代码放到一个同步块中,售票能一个售票完后,下一个才能进行售票)
            while(tickets > 0) {
                log.info(this.getClass().getName().toString());
                synchronized (this) {
                    if (tickets <= 0) {
                        return;
                    }
                    log.info(Thread.currentThread().getName()+"--->售出第：  "+tickets+" 票");
                    tickets--;
                }
                if (tickets <= 0) {
                    log.info(Thread.currentThread().getName()+"--->售票结束！");
                }
            }
        }
    }

    /**
     * 同步方法
     */
    class SellTicketsSecurity2 implements Runnable{
        @Override
        public void run() {
            //同步方法
            while (tickets > 0) {
                synMethod();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (tickets<=0) {
                    log.info(Thread.currentThread().getName()+"--->售票结束");
                }
            }
        }
        synchronized void synMethod() {
            synchronized (this) {
                if (tickets <=0) {
                    return;
                }
                log.info(Thread.currentThread().getName()+"---->售出第 "+tickets+" 票 ");
                tickets-- ;
            }
        }
    }

    /**
     * Lock锁机制， 通过创建Lock对象，采用lock()加锁，unlock()解锁，来保护指定的代码块
     */
    class SellTicketsSecurity3 implements Runnable{
        Lock lock = new ReentrantLock();
        @Override
        public void run() {
            // Lock锁机制
            while(tickets > 0) {
                try {
                    lock.lock();
                    if (tickets <= 0) {
                        return;
                    }
                    log.info(Thread.currentThread().getName()+"--->售出第：  "+tickets+" 票");
                    tickets--;
                } catch (Exception e1) {
                    e1.printStackTrace();
                }finally {
                    lock.unlock();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (tickets <= 0) {
                log.info(Thread.currentThread().getName()+"--->售票结束！");
            }
        }
    }
}
