package org.lxg.data.array;

public class BasicArray {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i ++)
            arr[i] = i;
        System.out.println("--------- 遍历1 ---------------");
        int[] scores = new int[]{100, 99, 66};
        for(int i = 0 ; i < scores.length ; i ++)
            System.out.println(scores[i]);
        System.out.println("--------- 遍历2 ---------------");
        for(int score: scores)
            System.out.println(score);

        System.out.println("--------- scores[0] = 96 修改后 ---------");
        scores[0] = 96;

        for(int i = 0 ; i < scores.length ; i ++)
            System.out.println(scores[i]);
    }
}
