package org.lxg.basic.patterns.single;

//静态内部类实现单例模式
public class Single_5 {
    private Single_5() { }
    public static final Single_5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
    private static class SingletonHolder {
        private static final Single_5 INSTANCE = new Single_5();
    }
}