package org.lxg.basic.data.stack;

import org.lxg.basic.data.array.SelfLinkedList;

/**
 * @author xuegangliu
 * 链表栈
 * @param <E>
 */
public class LinkedListStack<E> implements BaseStack<E> {
    private SelfLinkedList<E> list;

    public LinkedListStack(){
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
    public void push(E e){
        list.addFirst(e);
    }

    @Override
    public E pop(){
        return list.removeFirst();
    }

    @Override
    public E peek(){
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
