package org.lxg.basic.data.queue;

/**
 * @author xuegangliu
 * 队列为先进先出
 * 队列基本接口方法
 * @param <E>
 */
public interface BaseQueue<E> {

    /**
     * 获取队列大小
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队列
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队列
     * @return
     */
    E dequeue();

    /**
     * 获取队列头元素
     * @return
     */
    E getFront();
}
