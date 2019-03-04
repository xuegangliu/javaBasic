package org.lxg.basic.patterns.observer.observer;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/30/2018 11:47 AM
 * @DES:
 * @version: v1.0
 */
public class ObserverTest {

    @Test
    public void test(){
        CoderPig coderPig = new CoderPig();
        AndroidDev dev = new AndroidDev();
        coderPig.addObserver(dev);
        coderPig.update("Java中对观察者模式的支持~");
        coderPig.deleteObserver(dev);
    }
}
