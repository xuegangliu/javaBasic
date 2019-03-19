package com.lxg.problem.clazz.loader;

/**
 * 静态语句块、构造语句块以及构造函数的执行顺序
 * 1.静态语句块 > 2.父构造语句块、父构造函数 > 3.子构造语句块、子构造函数
 */
// 子类
public class Loader extends Hello {
    public String name = "子类属性值name!!";
    static {
        System.out.println("子类静态语句块:static {}");
    }

    {
        System.out.println("子类构造语句块:{}");
    }

    public Loader() {
        System.out.println("子类构造函数:Loader(){}");
    }

    public Loader(String name) {
        System.out.println("子类构造函数:Loader(String name){}:"+name);
    }

    // 相当于重写父类
    public void method1(){
        System.out.println("子类方法method1");
    }

    public void method3(){
        System.out.println("子类方法method3 start");
        Hello hello = new Hello();
        System.out.println(hello.name);
        hello.method1();
        System.out.println("子类方法method3 end");
    }
}

// 父类
class Hello{
    public String name = "父类属性值name!!";

    // 父类静态语句块
    static {
        System.out.println("父类静态语句块:static {}");
    }

    // 父类构造块
    {
        System.out.println("父类构造语句块:{}");
    }

    // 父类无参构造函数
    public Hello() {
        System.out.println("父类构造函数:Hello(){}");
    }

    // 父类有参参构造函数
    public Hello(String name) {
        System.out.println("父类构造函数:Hello(String name){}"+name);
    }

    public void method1(){
        System.out.println("父类方法method1");
    }

    public void method2(){
        System.out.println("父类方法method2");
    }

}