package org.lxg.basic.patterns.single;

/**
 * @author xuegangliu
 * 静态内部类实现单例模式
 */
public class Single5 {
    private Single5() { }
    public static final Single5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
    private static class SingletonHolder {
        private static final Single5 INSTANCE = new Single5();
    }
}