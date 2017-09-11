package com.lxg.patterns.single;

//懒汉模式(线程不安全，不可用)
public class Single_2 {
    private static Single_2 instance = null;
    private Single_2() { }
    private static Single_2 getInstance() {
        if(instance == null) {
            instance = new Single_2();
        }
        return instance;
    }
}