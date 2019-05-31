package org.lxg.basic.patterns.flyweight.fly;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class DiamondCard extends AbstractCard {

    public DiamondCard() { super(); }

    @Override public void showCard(String num) { System.out.println("方块：" + num); }
}
