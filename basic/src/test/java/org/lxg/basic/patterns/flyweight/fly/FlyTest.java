package org.lxg.basic.patterns.flyweight.fly;

import org.junit.Test;

/**
 * @author xuegangliu
 *  8/30/2018 3:31 PM
 *
 * @version: v1.0
 */
public class FlyTest {

    @Test
    public void test(){
        for (int k = 0; k < 10; k ++){
            AbstractCard card = null;
            //随机花色
            switch ((int)(Math.random()*4)) {
                case 0: card = PokerFactory.getPoker(PokerFactory.SPADE); break;
                case 1: card = PokerFactory.getPoker(PokerFactory.HEART); break;
                case 2: card = PokerFactory.getPoker(PokerFactory.CLUB); break;
                case 3: card = PokerFactory.getPoker(PokerFactory.DIAMOND); break;
            }
            if(card != null) {
                //随机大小
                int num = (int)(Math.random()*13 + 1);
                switch (num) {
                    case 11: card.showCard("J"); break;
                    case 12: card.showCard("Q"); break;
                    case 13: card.showCard("K"); break;
                    default: card.showCard(num+""); break;
                }
            }
        }
    }
}
