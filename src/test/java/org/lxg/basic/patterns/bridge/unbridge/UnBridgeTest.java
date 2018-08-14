package org.lxg.basic.patterns.bridge.unbridge;

import org.junit.Test;
import org.lxg.basic.patterns.bridge.bridge.*;

import java.util.Date;

/**
 * @author: xuegangliu
 * @date: 8/14/2018 11:09 AM
 * @DES:
 * @version: v1.0
 */
public class UnBridgeTest {

    @Test
    public void restaurantTest(){
        System.out.println("\n" + new Date(System.currentTimeMillis()));
        System.out.println("==================");

        Steak steak1 = new BeefSteak();
        steak1.sale();

        Steak steak2 = new PorkSteakRice();
        steak2.sale();

        Steak steak3 = new BeefSteakSpaghetti();
        steak3.sale();

        Steak steak4 = new ChickenSteakRice();
        steak4.sale();

        System.out.println("==================");
    }
}
