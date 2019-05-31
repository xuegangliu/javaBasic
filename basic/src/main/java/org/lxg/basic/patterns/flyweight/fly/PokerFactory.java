package org.lxg.basic.patterns.flyweight.fly;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuegangliu
 * @date 2017/2/26 0026.
 */
public class PokerFactory {
    /** 黑桃 */
    static final int SPADE = 0;
    /** 红桃 */
    static final int HEART  = 1;
    /** 梅花 */
    static final int CLUB  = 2;
    /** 方块 */
    static final int DIAMOND  = 3;

    public static Map<Integer, AbstractCard> pokers = new HashMap<>();

    public static AbstractCard getPoker(int color) {
        if (pokers.containsKey(color)) {
            System.out.print("对象已存在，对象复用...");
            return pokers.get(color);
        } else {
            System.out.print("对象不存在，新建对象...");
            AbstractCard card;
            switch (color) {
                case SPADE: card = new SpadeCard(); break;
                case HEART: card = new HeartCard(); break;
                case CLUB: card = new ClubCard(); break;
                case DIAMOND: card = new DiamondCard(); break;
                default: card = new SpadeCard(); break;
            }
            pokers.put(color,card);
            return card;
        }
    }
}
