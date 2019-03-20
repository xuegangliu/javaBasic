package org.lxg.basic.data.uf;

/**
 * 并查集基本方法
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q); // 查看元素p和元素q是否所属一个集合
    void unionElements(int p, int q); // 合并元素p和元素q所属的集合
}