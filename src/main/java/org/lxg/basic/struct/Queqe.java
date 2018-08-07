package org.lxg.basic.struct;

/**
 * 队列先进先出
 */
public class Queqe {
    private int array[];
    private int front;
    private int end;
    private int number;
    private int max;

    private Queqe(int maxsize){
        array = new int[maxsize];
        max = maxsize;
        front = 0;
        end = 0;
        number = 0;
    }

    private void insert(int item){
        if(isFull()){
            System.out.println("Queqe is full,can not insert");
            return;
        }
        array[end++] = item;
        number++;
    }

    private int remove(){
        if(isEmpty()){
            System.out.println("Queqe is empty,can not remove");
            return -1;
        }
        number--;
        return array[front++];
    }

    private boolean isFull(){
        return number == max;
    }
    private boolean isEmpty(){
        return number == 0;
    }

    private int size(){
        return number;
    }

    private int peekFront(){
        return array[front];
    }

    public static void main(String[] args) {
        Queqe q = new Queqe(4);
        System.out.println("queqe is empty:"+q.isEmpty());

        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);

        System.out.println(q.size());
        System.out.println("front is "+q.peekFront());

        while(!q.isEmpty())
            System.out.println(q.remove());
    }
}
