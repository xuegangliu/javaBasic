package org.lxg.basic.patterns.single;

/**
 * 枚举实现单例模式
 * @author xuegangliu
 */
public enum Single6 {
    /**
     * INSTANCE
     */
    INSTANCE;
    private Single instance;
    Single6() {
        instance = new Single();
    }
    public Single getInstance() {
        return instance;
    }

    class Single{
        private Single instance = new Single();
        private Single (){}
    }
}