package org.lxg.basic.data.set;

/**
 * @author xuegangliu
 * set基本方法
 * @param <E>
 */
public interface BaseSet<E> {

    /**
     * add
     * @param e
     */
    void add(E e);

    /**
     * contains
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * remove
     * @param e
     */
    void remove(E e);

    /**
     * getSize
     * @return
     */
    int getSize();

    /**
     * isEmpty
     * @return
     */
    boolean isEmpty();
}
