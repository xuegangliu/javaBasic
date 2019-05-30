package org.lxg.basic.data.array;

/**
 * @author xuegangliu
 * 自定义数组
 * @param <T> 数据类型
 */
public class SelfArray<T> {

    /**
     * 数组内容
     */
    public T[] data;

    /**
     * 数组大小
     */
    public int size;

    /**
     * 构造函数，传入数组的容量capacity构造SelfArray
     * @param capacity
     */
    public SelfArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public SelfArray(){
        this(10);
    }

    /**
     * SelfArray(T[] arr)
     * @param arr
     */
    public SelfArray(T[] arr){
        data = (T[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];
        size = arr.length;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(T e){
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(T e){
        add(0, e);
    }

    /**
     * 在index索引的位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, T e){

        if(size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        // 插入位置未中间,将后边的数据挪一位
        for(int i = size - 1; i >= index ; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;

        size ++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public T get(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, T e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(T e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(T e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     * @param index
     * @return
     */
    public T remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        T ret = data[index];
        for(int i = index + 1 ; i < size ; i ++) {
            data[i - 1] = data[i];
        }
        size --;
        return ret;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     * @return
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     * @return
     */
    public T removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(T e){
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    /**
     * 将数组空间的容量变成newCapacity大小
     * @param newCapacity
     */
    private void resize(int newCapacity){
        T[] newData = (T[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public T getLast(){
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public T getFirst(){
        return get(0);
    }

    /**
     * swap
     * @param i
     * @param j
     */
    public void swap(int i, int j){
        if(i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
