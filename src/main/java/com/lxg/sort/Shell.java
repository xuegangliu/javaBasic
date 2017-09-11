package com.lxg.sort;

/**
 * 希尔排序
 * 基本思想：先取一个小于 n 的整数 d1 作为第一个增量，把文件的全部记录分成 d1 个组。
 *      所有距离为 d1 的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
 *      然后，取第二个增量 d2<d1 重复上述的分组和排序，直至所取的增量 dt=1(dt<dt-l<…<d2<d1)，
 *      即所有记录放在同一组中进行直接插入排序为止。该方法实质上是一种分组插入方法。
 */
public class Shell {
    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        printBefore(a);
        //希尔排序
        int d = a.length;
        sort(a, d);
        printEnd(a);
    }

    public static void sort(int[] a, int d) {
        while(true){
            d = d / 2;
            for(int x=0;x<d;x++){
                for(int i=x+d;i<a.length;i=i+d){
                    int temp = a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d){
                        a[j+d] = a[j];
                    }
                    a[j+d] = temp;
                }
            }
            if(d == 1){
                break;
            }
        }
    }

    public static void printEnd(int[] a) {
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void printBefore(int[] a) {
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
