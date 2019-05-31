package com.lxg.problem.thread;

import lombok.extern.slf4j.Slf4j;

/**************************
 *  Thread
 * @author xuegangliu
 *  2019/3/19 17:46
 ***************************/

@Slf4j
public class Thread1 implements Runnable{

    private String name ;

    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        log.info("{}:{}is start",name,Thread.currentThread());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            log.info("{}:{} is end",name,Thread.currentThread());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
