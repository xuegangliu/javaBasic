package com.lxg.test;

/**
 * 静态语句块、构造语句块以及构造函数的执行顺序
 * 1.静态语句块 > 2.父构造语句块、父构造函数 > 3.子构造语句块、子构造函数
 */
class Hello{ // 父类
    public Hello() {
        System.out.println("父类构造函数:Hello(){}");
    }

    { System.out.println("父类构造语句块:{}"); }

    static { System.out.println("父类静态语句块:static {}"); }
}

public class Loader extends Hello {// 子类

    public Loader() {
        System.out.println("子类构造函数:Loader(){}");
    }

    { System.out.println("子类构造语句块:{}"); }

    static { System.out.println("子类静态语句块:static {}"); }

    public static void main(String[] args) {
        System.out.println("-------main start-------");
        new Loader();
        System.out.println("------------------------");
        new Loader();
        System.out.println("-------main end-------");
    }
}
