package org.lxg.data.set;

import org.lxg.data.array.SelfLinkedList;

public class LinkedListSet<E> implements BaseSet<E> {
    private SelfLinkedList<E> list;

    public LinkedListSet(){
        list = new SelfLinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void add(E e){
        if(!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public boolean contains(E e){
        return list.contains(e);
    }

    @Override
    public void remove(E e){
        list.removeElement(e);
    }

}
