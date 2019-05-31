package org.lxg.basic.sample.inte;

/**
 * @author xuegangliu
 *  9/3/2018 4:26 PM
 *
 * @version: v1.0
 */
public abstract class BaseAbstract {
    public static void main(String[] args) {
        System.out.println("抽象类的main方法");
    }
    public BaseAbstract(){
        System.out.println("抽象类构造器");
    }
    abstract void helloAbstract();
}
