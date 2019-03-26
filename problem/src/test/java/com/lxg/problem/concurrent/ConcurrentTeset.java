package com.lxg.problem.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: ConcurrentTeset
 * @author: xuegangliu
 * @date: 2019/3/26 10:30
 ***************************/
@Slf4j
public class ConcurrentTeset {

    @Test
    public void test1(){

        BoundedBuffer boundedBuffer = new BoundedBuffer(new Object[]{"111","222"});
        log.info("{}",boundedBuffer.items.length);
        try {
            boundedBuffer.put("333");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}",boundedBuffer.items.length);
        try {
            boundedBuffer.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{}",boundedBuffer.items.length);

    }
}
