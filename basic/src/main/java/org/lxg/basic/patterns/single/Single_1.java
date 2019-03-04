package org.lxg.basic.patterns.single;

//饿汉模式
public class Single_1{
    private static Single_1 instance = new Single_1();
    private Single_1(){ }
    public static Single_1 getInstance() {
        return instance;
    }
}