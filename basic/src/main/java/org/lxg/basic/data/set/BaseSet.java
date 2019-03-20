package org.lxg.basic.data.set;

/**
 * set基本方法
 * @param <E>
 */
public interface BaseSet<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
