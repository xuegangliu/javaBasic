package org.lxg.basic.patterns.template;

/**
 * @author: xuegangliu
 * @date: 8/28/2018 3:33 PM
 * @DES:
 * @version: v1.0
 */
public class Cricket extends Game {
    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
