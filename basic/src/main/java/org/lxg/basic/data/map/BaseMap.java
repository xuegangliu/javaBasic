package org.lxg.basic.data.map;

/**
 * @author xuegangliu
 * map基本方法
 * @param <K>
 * @param <V>
 */
public interface BaseMap<K,V> {

    /**
     * add
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * remove
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * contains
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * get
     * @param key
     * @return
     */
    V get(K key);

    /**
     * set
     * @param key
     * @param newValue
     */
    void set(K key, V newValue);

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
