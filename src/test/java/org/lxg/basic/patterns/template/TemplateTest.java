package org.lxg.basic.patterns.template;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/28/2018 3:34 PM
 * @DES:
 * @version: v1.0
 */
public class TemplateTest {

    @Test
    public void templeTest(){
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
