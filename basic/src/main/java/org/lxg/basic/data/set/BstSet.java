package org.lxg.basic.data.set;

import org.lxg.basic.data.tree.Bst;

/**
 * @author xuegangliu
 * 基于二叉树的set
 * @param <E>
 */
public class BstSet<E extends Comparable<E>> implements BaseSet<E> {

    private Bst<E> bst;

    public BstSet(){
        bst = new Bst<>();
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }
}
