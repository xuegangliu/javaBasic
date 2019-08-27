package org.lxg.basic.patterns.single;

/**
 * 饿汉模式
 * @author xuegangliu
 */
public class Single1 {
    private static Single1 instance = new Single1();
    private Single1(){ }
    public static Single1 getInstance() {
        return instance;
    }
}