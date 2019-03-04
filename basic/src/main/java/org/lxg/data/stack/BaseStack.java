package org.lxg.data.stack;

/**
 * 栈为后进先出
 * 栈基本方法
 * @param <E>
 */
public interface BaseStack<E> {
    int getSize(); // 栈数据大小
    boolean isEmpty(); // 栈是否为空
    void push(E e); // 入栈
    E pop(); // 出栈
    E peek(); // 栈顶元素
}
