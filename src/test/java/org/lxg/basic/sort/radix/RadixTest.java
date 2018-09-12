package org.lxg.basic.sort.radix;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 9/12/2018 11:00 AM
 * @DES:
 * @version: v1.0
 */
public class RadixTest {

    @Test
    public void testRadix(){
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        Radix.printBefore(a);
        //基数排序
        Radix.sort(a);
        Radix.printEnd(a);
    }
}
