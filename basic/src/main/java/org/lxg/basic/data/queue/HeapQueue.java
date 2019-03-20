package org.lxg.basic.data.queue;

import org.lxg.basic.data.heap.MaxHeap;

/**
 * 基于堆实现的队列
 * @param <E>
 */
public class HeapQueue<E extends Comparable<E>>  implements BaseQueue<E> {
    private MaxHeap<E> maxHeap;

    public HeapQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize(){
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        return maxHeap.extractMax();
    }
}
