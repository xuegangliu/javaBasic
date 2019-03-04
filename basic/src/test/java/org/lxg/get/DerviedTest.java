package org.lxg.get;

import org.junit.Test;
import org.lxg.get.Dervied;

/**
 * @author: xuegangliu
 * @date: 8/15/2018 2:43 PM
 * @DES:
 * @version: v1.0
 */
public class DerviedTest {

    @Test
    public void Dervied(){
        new Dervied();
    }

    @Test
    public void DerviedBase(){
        new Dervied().base();
    }
}
