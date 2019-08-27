package org.lxg.basic.patterns.flyweight.fly;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class ClubCard extends AbstractCard {

    public ClubCard() { super(); }

    @Override public void showCard(String num) { System.out.println("梅花：" + num); }
}
