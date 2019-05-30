package org.lxg.basic.data.tree;

/**
 * Merger
 * @param <E>
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
