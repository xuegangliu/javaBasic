package org.lxg.basic.patterns.flyweight.fly;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class SpadeCard extends AbstractCard {

    public SpadeCard() { super(); }

    @Override public void showCard(String num) { System.out.println("黑桃：" + num); }
}
