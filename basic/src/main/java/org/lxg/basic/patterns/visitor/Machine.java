package org.lxg.basic.patterns.visitor;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public interface Machine {

    /**
     * accept
     * @param player
     */
    void accept(Player player);
}
