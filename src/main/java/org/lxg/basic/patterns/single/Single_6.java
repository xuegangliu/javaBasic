package org.lxg.basic.patterns.single;

//枚举实现单例模式
public enum Single_6 {
    INSTANCE;
    private Single instance;
    Single_6() {
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