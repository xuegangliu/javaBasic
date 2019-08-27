package org.lxg.basic.patterns.template;

/**
 * @author xuegangliu
 *  8/28/2018 3:33 PM
 *
 * @version: v1.0
 */
public class Football extends AbstractGame {
    @Override
    void endPlay() {
        System.out.println("Football AbstractGame Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football AbstractGame Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football AbstractGame Started. Enjoy the game!");
    }
}
