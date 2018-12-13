package org.lxg.data.v1;

/**
 * 队列先进先出
 */
public class Queqe {
    private int array[];
    private int front;
    private int end;
    private int number;
    private int max;

    Queqe(int maxsize){
        array = new int[maxsize];
        max = maxsize;
        front = 0;
        end = 0;
        number = 0;
    }

    void insert(int item){
        if(isFull()){
            System.out.println("Queqe is full,can not insert");
            return;
        }
        array[end++] = item;
        number++;
    }

    int remove(){
        if(isEmpty()){
            System.out.println("Queqe is empty,can not remove");
            return -1;
        }
        number--;
        return array[front++];
    }

    boolean isFull(){
        return number == max;
    }
    boolean isEmpty(){
        return number == 0;
    }

    int size(){
        return number;
    }

    int peekFront(){
        return array[front];
    }
}
