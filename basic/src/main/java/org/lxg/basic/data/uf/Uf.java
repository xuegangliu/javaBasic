package org.lxg.basic.data.uf;

/**
 * @author xuegangliu
 * 并查集基本方法
 */
public interface Uf {

    /**
     * 获取个数
     * @return
     */
    int getSize();

    /**
     * 查看元素p和元素q是否所属一个集合
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}