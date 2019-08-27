package org.lxg.basic.patterns.flyweight;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuegangliu
 *  8/30/2018 3:29 PM
 *
 * @version: v1.0
 */
public class FlyweightTest {

    @Test
    public void test(){
        String[] colors = new String[] {"黑桃","红心","梅花","方块"};
        List<Card> cards = new ArrayList<>();
        for(int i = 0;i < 4; i++ ) {
            for (int j = 1;j <= 13;j ++) {
                switch (j) {
                    case 11: cards.add(new Card(colors[i],"J")); break;
                    case 12: cards.add(new Card(colors[i],"Q")); break;
                    case 13: cards.add(new Card(colors[i],"K")); break;
                    default: cards.add(new Card(colors[i],j + "")); break;
                }
            }
        }
        System.out.println("扑克牌初始化完毕，共：" + cards.size() + "张");
        System.out.println("随机分5张牌：");
        for (int k = 0; k < 5; k ++){
            System.out.println(cards.get((int)(Math.random()*52)));
        }
    }
}
