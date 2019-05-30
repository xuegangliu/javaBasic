package com.lxg.core.util;

import java.util.List;
import java.util.Map;

/**
 * Spring-Core MultiValueMap
 * @author xuegangliu
 */
public interface MultiValueMap<K, V> extends Map<K, List<V>> {
    /**
     * 获取第一个key值
     * @param var1
     * @return
     */
    V getFirst(K var1);

    /**
     * 添加一个k,v
     * @param var1
     * @param var2
     */
    void add(K var1, V var2);

    /**
     * 设置一个k,v
     * @param var1
     * @param var2
     */
    void set(K var1, V var2);

    /**
     * 设置所有的k,v
     * @param var1
     */
    void setAll(Map<K, V> var1);

    /**
     * toSingleValueMap
     * @return
     */
    Map<K, V> toSingleValueMap();
}
