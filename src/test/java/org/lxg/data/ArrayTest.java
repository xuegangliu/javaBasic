package org.lxg.data;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testBasicArray(){
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i ++)
            arr[i] = i;

        logger.info("--------- 遍历1 ---------------");
        int[] scores = new int[]{100, 99, 66};
        for(int i = 0 ; i < scores.length ; i ++)
            logger.info(scores[i]+"");

        logger.info("--------- 遍历2 ---------------");
        for(int score: scores)
            logger.info(score+"");

        logger.info("--------- scores[0] = 96 修改后 ---------");
        scores[0] = 96;
        for(int i = 0 ; i < scores.length ; i ++)
            logger.info(scores[i]+"");
    }

    @Test
    public void testSelfArray(){
        SelfArray selfArray = new SelfArray();
        logger.info("数据大小:{},数组容量:{}",selfArray.getSize(),selfArray.getCapacity());

        selfArray.addFirst(1);
        selfArray.add(1,2);
        printSelfData(selfArray);

        logger.info("数据大小:{},数组容量:{}",selfArray.getSize(),selfArray.getCapacity());
        selfArray.addLast(3);
        printSelfData(selfArray);

        selfArray.add(1,5);
        logger.info("数据大小:{},数组容量:{}",selfArray.getSize(),selfArray.getCapacity());
        printSelfData(selfArray);
    }

    public void printSelfData(SelfArray selfArray){
        StringBuffer data = new StringBuffer();
        for(int t:selfArray.data){
            data.append(t+",");
        }
        logger.info(data.toString());
    }
}
