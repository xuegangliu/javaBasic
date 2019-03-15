package org.lxg.basic.t.son;

import org.lxg.basic.t.father.FatherA;

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
        tt();
        System.out.println("SonB()");
    }
    public SonB(String name){
        tt();
        System.out.println("SonB(String name)");
    }

    public void tt(){
        System.out.println("son tt");
    }
}
