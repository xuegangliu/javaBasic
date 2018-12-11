package org.lxg.data;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void testBasicArray(){
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

    @Test
    public void testSelfArray(){
        SelfArray selfArray = new SelfArray();
        selfArray.addFirst(1);
        selfArray.add(1,5);
        System.out.println(selfArray.getSize());
        selfArray.addLast(5);
        System.out.println(selfArray.getSize());
    }
}
