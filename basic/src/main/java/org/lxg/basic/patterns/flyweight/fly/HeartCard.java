package org.lxg.basic.patterns.flyweight.fly;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class HeartCard extends AbstractCard {

    public HeartCard() { super(); }

    @Override public void showCard(String num) { System.out.println("红桃：" + num); }
}
