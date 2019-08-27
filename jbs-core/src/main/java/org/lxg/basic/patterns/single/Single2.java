package org.lxg.basic.patterns.single;

/**
 * @author xuegangliu
 * 懒汉模式(线程不安全，不可用)
 */
public class Single2 {
    private static Single2 instance = null;
    private Single2() { }
    private static Single2 getInstance() {
        if(instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}