package org.lxg.basic.data.stack;

/**
 * @author xuegangliu
 * 栈为后进先出
 * 栈基本方法
 * @param <E>
 */
public interface BaseStack<E> {

    /**
     * 栈数据大小
     * @return
     */
    int getSize();

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 栈顶元素
     * @return
     */
    E peek();
}
