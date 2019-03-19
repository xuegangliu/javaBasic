package com.lxg.problem.others;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**************************
 * @description: ValidationTest
 * @author: xuegangliu
 * @date: 2019/3/14 16:14
 ***************************/
@Slf4j
public class ValidationTest {

    @Test
    // <<、>>、>>>移位操作
    public void test1(){
      int cap1 = 1;
      int cap2 = 2;
      int cap3 = 3;
      int cap4 = 4;
      int k = 50;
        System.out.println("十进制:" + k + ", 二进制:" + Integer.toBinaryString(k));
        System.out.println(20 >> 0);

      log.info("cap1 >> 1:{}",(cap1 >> 1));
      log.info("cap2 >> 1:{}",(cap2 >> 1));
      log.info("cap3 >> 1:{}",(cap3 >> 1));
      log.info("cap4 >> 1:{}",(cap4 >> 1));

    }

    @Test
    public void testlist1(){
        Vector<Integer> integerVector = new Vector<>();
        List<Integer> list = new ArrayList<>(20);
        System.out.println(list.iterator());
        for(int i=0;i<30;i++){
            list.add(i);
            integerVector.add(i);
//            log.info("{}",list.size());
        }
        log.info("{}",list.size());
    }

    @Test
    public void testLinkeList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<10;i++){
            linkedList.add(i);
        }
        for(int i=10;i<15;i++){
            linkedList.addFirst(i);
        }
        for(int i=15;i<20;i++){
            linkedList.addLast(i);
        }
        log.info(linkedList.toString());
    }

    @Test
    public void testlll(){
        if(3>3)
            log.info("{}",(3>3));
    }
}
