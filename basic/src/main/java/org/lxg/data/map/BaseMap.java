package org.lxg.data.map;

/**
 * map基本方法
 * @param <K>
 * @param <V>
 */
public interface BaseMap<K,V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
