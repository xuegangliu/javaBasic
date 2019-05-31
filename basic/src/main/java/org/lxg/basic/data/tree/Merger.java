package org.lxg.basic.data.tree;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public interface Merger<E> {

    /**
     * merge
     * @param a
     * @param b
     * @return
     */
    E merge(E a, E b);
}
