package org.lxg.basic.sort.exchange;

import org.junit.Test;

/**
 * @author xuegangliu
 *  9/12/2018 10:15 AM
 *
 * @version: v1.0
 */
public class ExchangeTest {

    @Test
    public void testBubble(){
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        Bubble.printBefore(a);
        //冒泡排序
        Bubble.sort(a);
        Bubble.printEnd(a);
    }

    @Test
    public void testQuick(){
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        Quick.printBefore(a);
        //快速排序
        Quick.quick(a);
        Quick.printEnd(a);
    }
}
