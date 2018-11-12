package org.lxg.basic.sample.reflection;

/**
 * @author: xuegangliu
 * @date: 11/12/2018 11:35 AM
 * @DES:
 * @version: v1.0
 */
public class A {

    public int age=0;
    public static String A_STATIS_PARAM = "this is statis param";

    static {
        System.out.println("this is class A statis block!");
    }

    public static void sayHello(){
        System.out.println("this class static method sayHello()");
    }

    public String talk(String name){
        System.out.println("hello " +name);
        return "hello " +name;
    }

    public A(){
        System.out.println("空构造器");
    }

    public A(String name){
        System.out.println("有参构造器");
    }
}
