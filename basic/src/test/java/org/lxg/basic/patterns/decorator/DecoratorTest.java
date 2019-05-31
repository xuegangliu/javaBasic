package org.lxg.basic.patterns.decorator;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/23/2018 2:36 PM
 * @DES:
 * @version: v1.0
 */
public class DecoratorTest {

    @Test
    public void decoratorTest(){
        AbstractTea tea1 = new MilkTea();
        System.out.println("你点的是：" + tea1.getName() + " 价格为：" + tea1.price());

        AbstractTea tea2 = new LemonTea();
        tea2 = new JinJu(tea2);
        System.out.println("你点的是：" + tea2.getName() + " 价格为：" + tea2.price());

        AbstractTea tea3 = new MilkTea();
        tea3 = new ZhenZhu(tea3);
        tea3 = new YeGuo(tea3);
        tea3 = new HongDou(tea3);
        tea3 = new JinJu(tea3);
        System.out.println("你点的是：" + tea3.getName() + " 价格为：" + tea3.price());
    }
}
