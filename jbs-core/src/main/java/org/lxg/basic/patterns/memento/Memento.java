package org.lxg.basic.patterns.memento;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Memento {
    private int hp;
    private int mp;
    private int money;

    public Memento(int hp, int mp, int money) {
        this.hp = hp;
        this.mp = mp;
        this.money = money;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getMoney() {
        return money;
    }
}
