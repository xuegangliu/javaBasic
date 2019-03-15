package org.lxg.basic.t.father;

/**
 * @author: xuegangliu
 * @date: 11/19/2018 11:15 AM
 * @DES:
 * @version: v1.0
 */
public class FatherA {
    public static int a=5;
    public String name;

    static {
        System.out.println("FatherA.static{}");
    }
    public static void FatherStaticMethod(){
        System.out.println("FatherA.FatherStaticMethod");
    }

    public FatherA(){
        tt();
        System.out.println("FatherA()");
    }

    public FatherA(String name){
        System.out.println("FatherA(name)");
        tt();
    }

    public void tt(){
        System.out.println("FatherA tt");
    }
}
