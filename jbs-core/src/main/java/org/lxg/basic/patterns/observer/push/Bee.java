package org.lxg.basic.patterns.observer.push;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Bee implements Insect{

    /**
     * 蜜蜂编号
     */
    private int bId;

    public Bee(int bId) { this.bId = bId; }

    @Override public void work() { System.out.println("蜜蜂"+ bId + "采蜜"); }

    @Override public void unWork() { System.out.println("蜜蜂"+ bId + "回巢"); }
}
