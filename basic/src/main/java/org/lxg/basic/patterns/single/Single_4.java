package org.lxg.basic.patterns.single;

//懒汉模式双重校验锁
public class Single_4 {
    private static volatile Single_4 instance = null;
    private Single_4() { }
    public static Single_4 getInstance() {
        if(instance == null) {
            synchronized(Single_4.class) {
                if(instance == null) {
                    instance = new Single_4();
                }
            }
        }
        return instance;
    }
}