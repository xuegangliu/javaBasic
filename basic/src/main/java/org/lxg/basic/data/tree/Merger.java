package org.lxg.basic.data.tree;

public interface Merger<E> {
    E merge(E a, E b);
}
