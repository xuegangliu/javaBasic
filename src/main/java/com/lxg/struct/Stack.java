package com.lxg.struct;

import java.util.Scanner;

/**
 * 栈是先进后出的数据的结构
 */
public class Stack {
    private int array[];
    private int max;
    private int top;
    public Stack(int max){
        this.max = max;
        array = new int[max];
        top = 0;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("full,can not insert");
            return;
        }
        array[top++]=value;
    }
    public int pop(){
        return array[--top];
    }
    public boolean isEmpty(){
        if(top == 0){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(top == max ){
            return true;
        }
        return false;
    }
    public void display(){
        while(!isEmpty()){
            System.out.println(pop());
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(1);
        s.push(3);
        s.push(5);
        s.push(5);
        s.push(5);
        s.display();//5 5 5 3 1
    }
}
