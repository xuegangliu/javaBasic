package org.lxg.basic.t.son;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 11/19/2018 11:26 AM
 * @DES:
 * @version: v1.0
 */
public class SonTest {

    @Test
    public void test1(){
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
