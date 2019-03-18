package com.lxg.problem.clazz.son;

import com.lxg.problem.clazz.father.FatherA;

/**
 * @author: xuegangliu
 * @date: 11/19/2018 11:25 AM
 * @DES:
 * @version: v1.0
 */
public class SonB extends FatherA {

    static {
        System.out.println("SonB static{}");
    }


    public SonB(){
        System.out.println("SonB()");
        tt();
    }
    public SonB(String name){
        System.out.println("SonB(String name)");
        tt();
    }

    public void tt(){
        System.out.println("son tt");
    }
}
