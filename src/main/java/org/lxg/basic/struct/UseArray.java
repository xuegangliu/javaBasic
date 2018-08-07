package org.lxg.basic.struct;

public class UseArray {
    public static void main(String[] args) {
        int array[] = new int[10];
        System.out.println(array[2]);// 输出0
        UseArray a[] = new UseArray[12];
        System.out.println(a[1]);// 输出null
        int array2[] ={1,2,3,4,5,5,6};
    }
}
