package org.lxg.basic.struct;

import java.util.Scanner;

/**
 * 栈是先进后出的数据的结构
 */
public class Stack {
    private char array[];
    private int max;
    private int top;
    public Stack(int max){
        this.max = max;
        array = new char[max];
        top = 0;
    }
    public void push(char value){
        if(isFull()){
            System.out.println("full,can not insert");
            return;
        }
        array[top++]=value;
    }
    public char pop(){
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

    /**
     * 单词逆序
     * @param in
     * @return
     */
    public String reverse(char [] in){
        String out="";
        for (int i = 0; i < in.length; i++) {
            char c = in[i];
            push(c);
        }
        while(!isEmpty()){
            out+=pop();
        }
        return out;
    }
}
