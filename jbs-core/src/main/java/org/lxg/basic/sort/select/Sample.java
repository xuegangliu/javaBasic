package org.lxg.basic.sort.select;

/**
 * @author xuegangliu
 * 简单的选择排序
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 *          然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止
 */
public class Sample {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            //最小数的索引
            int n=i;
            for(int j=i+1;j<a.length;j++){
                //找出最小的数
                if(a[j]<min){
                    min = a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;

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
