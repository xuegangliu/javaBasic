package com.lxg.problem.others;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**************************
 *  OthersTest
 * @author xuegangliu
 *  2019/3/19 17:15
 ***************************/

@Slf4j
public class OthersTest {
    @Test
    public void test1(){
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println();

        HashFunction student = new HashFunction(3, 2, "Bobo", "Liu");
        System.out.println(student.hashCode());

        HashSet<HashFunction> set = new HashSet<>();
        set.add(student);

        System.out.printf(String.valueOf(set.hashCode()));
        HashMap<HashFunction, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        System.out.println(scores.hashCode());

        HashFunction student2 = new HashFunction(3, 2, "Bobo", "Liu");
        System.out.println(student2.hashCode());
    }

//    @Test
    public void test111(){
        Runnable t= new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    log.info("ssss");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        List<Thread> list= new ArrayList<Thread>();
        for(int i=0;i<=10;i++){
            Thread s = new Thread(t);
            s.setName("bb"+i);
            s.start();
            if(i%2==0)
                s.setPriority(6);
            list.add(s);
        }

        for(Thread k:list){
            k.start();
//            Thread.yield();
//                k.join(); // 等待当前线程执行完,才处理下边
            log.info("is end");
        }
    }

    @Test
    public void tt(){
        String a="153936661111";
        log.error("{}",a.substring(5));
    }


}
