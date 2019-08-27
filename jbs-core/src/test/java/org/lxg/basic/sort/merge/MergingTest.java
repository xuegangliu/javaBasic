package org.lxg.basic.sort.merge;

import org.junit.Test;

/**
 * @author xuegangliu
 *  9/12/2018 10:59 AM
 *
 * @version: v1.0
 */
public class MergingTest {

    @Test
    public void mergTest(){
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        Merging.printBefore(a);
        //归并排序
        Merging.mergeSort(a,0,a.length-1);
        Merging.printEnd(a);
    }
}
