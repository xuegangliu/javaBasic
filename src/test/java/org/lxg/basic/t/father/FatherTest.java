package org.lxg.basic.t.father;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 11/19/2018 11:19 AM
 * @DES:
 * @version: v1.0
 */
public class FatherTest {

    @Test
    public void test1(){
        new FatherA(  );
        System.out.println("=================");
        new FatherA( "name" );
        System.out.println("=============");
        String name = "Hello";
        setT( name );
        System.out.println(name);
    }

    public static void setT(String name){
        name = name + " World";
        System.out.println("static void print"+ name);
    }
}
