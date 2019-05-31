package org.lxg.basic.sort.select;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xuegangliu
 *  9/12/2018 11:04 AM
 *
 * @version: v1.0
 */
public class SelectTest {

    @Test
    public void heapTest(){
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
        int arrayLength=a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            Heap.buildMaxHeap(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            Heap.swap(a,0,arrayLength-1-i);
            System.out.println( Arrays.toString(a));
        }
    }

    @Test
    public void sampleTest(){
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        Sample.printBefore(a);
        //简单的选择排序
        Sample.sort(a);
        Sample.printEnd(a);
    }
}
