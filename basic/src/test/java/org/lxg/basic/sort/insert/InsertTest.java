package org.lxg.basic.sort.insert;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 9/12/2018 10:55 AM
 * @DES:
 * @version: v1.0
 */
public class InsertTest {

    @Test
    public void dichotomyTest(){
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        Dichotomy.printBefore(a);
        //二分插入排序
        Dichotomy.sort(a);
        Dichotomy.printEnd(a);
    }

    @Test
    public void directlnsertionTest(){
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        // 打印排序前
        DirectInsertion.printBefore(a);
        //直接插入排序
        DirectInsertion.sort(a);
        // 打印排序后
        DirectInsertion.printEnd(a);
    }

    @Test
    public void shellTest(){
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        Shell.printBefore(a);
        //希尔排序
        int d = a.length;
        Shell.sort(a, d);
        Shell.printEnd(a);
    }
}
