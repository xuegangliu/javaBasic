package org.lxg.basic.data.stack;

import org.lxg.basic.data.array.SelfArray;

/**
 * 基于数组实现的栈
 * @param <E>
 */
public class ArrayStack<E> implements BaseStack<E> {
    private SelfArray<E> array;

    public ArrayStack(int capacity){
        array = new SelfArray<>(capacity);
    }

    public ArrayStack(){
        array = new SelfArray<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
