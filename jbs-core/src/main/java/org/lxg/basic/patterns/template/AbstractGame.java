package org.lxg.basic.patterns.template;

/**
 * @author xuegangliu
 *  8/28/2018 3:32 PM
 *
 * @version: v1.0
 */
public abstract class AbstractGame {

    /**
     * initialize
     */
    abstract void initialize();

    /**
     * startPlay
     */
    abstract void startPlay();

    /**
     * endPlay
     */
    abstract void endPlay();

    /**
     * 模板
     */
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
