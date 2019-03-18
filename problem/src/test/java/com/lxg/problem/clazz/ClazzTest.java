package com.lxg.problem.clazz;

import com.lxg.problem.clazz.father.FatherA;
import com.lxg.problem.clazz.son.SonB;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: ClazzTest
 * @author: xuegangliu
 * @date: 2019/3/18 10:10
 ***************************/
@Slf4j
public class ClazzTest {

    @Test
    public void testFather(){
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

    @Test
    public void testSon(){
        new SonB(  );
    }

    @Test
    public void test2(){
//        System.out.println(abc( 0 ));
        System.out.println(abc( 1 ));
        System.out.println(abc( 2 ));
        System.out.println(abc( 3 ));
        System.out.println(abc( 5 ));
    }

    public int abc(int n){
        if(n<1)
            return 0;
        if(n==1)
            return 1;
        else
            return n*abc( n-1 );
    }
}
