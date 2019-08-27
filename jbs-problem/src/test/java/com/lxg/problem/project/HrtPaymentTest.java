package com.lxg.problem.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * HrtPaymentTest
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/07/17
 * @since 1.8
 **/
@Slf4j
public class HrtPaymentTest {

    @Test
    public void interTest(){
        Integer a1 = 1200;
        Integer a2 = 1200;
        Integer a3 = 6500;
        int b1 = 1200;
        int b2 = a2;

        log.info("{}",a1==b1);
        log.info("{}",b1==a1);
        log.info("{}",b1==b2);
        log.info("{}",a1==a2);
        log.info("{}",a3==50000);
        log.info("{}",50000==a3);
    }

    @Test
    public void testA(){
        A t1 = new A();
//        t1.setAge(6500);
        log.info("{}",t1.getAge());
        log.info("{}",t1.getAge()==6500);
        log.info("{}",6500==t1.getAge());
    }

    @Test
    public void test11() throws IOException {
        log.info("{}",Runtime.getRuntime().availableProcessors());

        InputStreamReader inputStreamReader= new InputStreamReader(Runtime.getRuntime().exec(new String[]{ "cmd","/c"}).getInputStream());
        //字符缓冲流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //字符串缓冲区
        StringBuilder stringBuilder = new StringBuilder();
        //
        String len = null;
        //按行读
        while((len=bufferedReader.readLine())!=null){
            //追加到字符串缓冲区存放
            stringBuilder.append(len);
        }
        //将字符串返回
        log.info("{}",stringBuilder.toString());
    }

    @Test
    public void testAA(){
        log.info("");
    }

    @Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String t="";
        boolean is=false;
        if(list.size()>0){
            int tt = 0;
            for (String s : list) {
                if(s.equals("2")){
                    t=s;
                    is=true;
                }else{
                    tt++;
                    t=s;
                }
                if(is || tt==list.size()){
                    log.error("{}",t);
                    break;
                }
            }
        }
    }

    class A{
        private Integer age;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        A(){
            age=6500;
        }
    }
}
