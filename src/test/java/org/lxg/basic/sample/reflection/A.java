package org.lxg.basic.sample.reflection;

import org.lxg.basic.patterns.observer.pull.PullTest;

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
}
