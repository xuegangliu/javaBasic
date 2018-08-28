package org.lxg.basic.patterns.template;

/**
 * @author: xuegangliu
 * @date: 8/28/2018 3:32 PM
 * @DES:
 * @version: v1.0
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
