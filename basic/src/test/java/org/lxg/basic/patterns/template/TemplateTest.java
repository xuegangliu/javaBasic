package org.lxg.basic.patterns.template;

import org.junit.Test;

/**
 * @author xuegangliu
 *  8/28/2018 3:34 PM
 *
 * @version: v1.0
 */
public class TemplateTest {

    @Test
    public void templeTest(){
        AbstractGame game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
