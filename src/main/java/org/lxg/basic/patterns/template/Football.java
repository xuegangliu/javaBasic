package org.lxg.basic.patterns.template;

/**
 * @author: xuegangliu
 * @date: 8/28/2018 3:33 PM
 * @DES:
 * @version: v1.0
 */
public class Football extends Game {
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
