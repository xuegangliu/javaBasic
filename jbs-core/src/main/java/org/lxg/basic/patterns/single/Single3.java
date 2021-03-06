package org.lxg.basic.patterns.single;

/**
 * @author xuegangliu
 * 懒汉模式(线程安全，但效率低，不推荐使用)
 */
public class Single3 {
    private static Single3 instance = null;
    private Single3() { }
    public static synchronized Single3 getInstance() {
        if(instance == null) {
            instance = new Single3();
        }
        return instance;
    }
}