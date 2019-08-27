package org.lxg.basic.patterns.bridge.bridge;

import org.junit.Test;

import java.util.Date;

/**
 * @author xuegangliu
 *  8/14/2018 11:09 AM
 *
 * @version: v1.0
 */
public class BridgeTest {

    @Test
    public void restaurantTest(){
        System.out.println("\n" + new Date(System.currentTimeMillis()));
        System.out.println("==================");

        AbstractSteak steak1 = new BeefSteak(new Rice());
        System.out.println("卖出了一份：" + steak1.sale());

        AbstractSteak steak2 = new PorkSteak(new Spaghetti());
        System.out.println("卖出了一份：" + steak2.sale());

        AbstractSteak steak3 = new PorkSteak(null);
        System.out.println("卖出了一份：" + steak3.sale());

        AbstractSteak steak4 = new ChickenSteak(new Rice());
        System.out.println("卖出了一份：" + steak4.sale());

        AbstractSteak steak5 = new LambSteak(new Spaghetti());
        System.out.println("卖出了一份：" + steak5.sale());

        AbstractSauces sauces1 = new FanQieSauces(new PorkSteak(new Rice()));
        System.out.println("卖出了一份：" + sauces1.sauces());

        AbstractSauces sauces2 = new HeiJiaoSauces(new BeefSteak(new Spaghetti()));
        System.out.println("卖出了一份：" + sauces2.sauces());

        AbstractSauces sauces3 = new XiangCaoSauces(new ChickenSteak(null));
        System.out.println("卖出了一份：" + sauces3.sauces());


        System.out.println("==================");
    }
}
