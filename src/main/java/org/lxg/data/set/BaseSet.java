package org.lxg.data.set;

public interface BaseSet<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
