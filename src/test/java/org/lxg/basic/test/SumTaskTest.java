package org.lxg.basic.test;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author: xuegangliu
 * @date: 8/21/2018 10:09 AM
 * @DES:
 * @version: v1.0
 */
public class SumTaskTest {

    @Test
    public void sumTest(){
        // 创建随机数组成的数组:
        long[] array = new long[400];
        fillRandom(array);
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    public void fillRandom(long[] array){
        for(int i=0;i<array.length;i++){
            array[i]= (long) Math.random()*100;
        }

    }
}
