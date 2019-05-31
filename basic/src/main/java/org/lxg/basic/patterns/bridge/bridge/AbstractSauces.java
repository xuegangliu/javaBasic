package org.lxg.basic.patterns.bridge.bridge;

/**
 * @author xuegangliu
 *  描述：酱汁大类
 * @date 2017/2/5 0005.
 */
abstract class AbstractSauces {
    AbstractSteak steak;

    AbstractSauces(AbstractSteak steak) { this.steak = steak; }

    /**
     * sauces
     * @return
     */
    abstract String sauces();
}
