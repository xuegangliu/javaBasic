package org.lxg.basic.patterns.bridge.bridge;

/**
 *  描述：酱汁大类
 * Created by Administrator on 2017/2/5 0005.
 */
abstract class Sauces {
    Steak steak;

    Sauces(Steak steak) { this.steak = steak; }

    abstract String sauces();
}
