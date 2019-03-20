package org.lxg.basic.data.queue;

/**
 * 队列为先进先出
 * 队列基本接口方法
 * @param <E>
 */
public interface BaseQueue<E> {
    int getSize(); // 获取队列大小
    boolean isEmpty(); // 队列是否为空
    void enqueue(E e); // 入队列
    E dequeue(); // 出队列
    E getFront(); // 获取队列头元素
}
