package com.lxg.problem.clazz;

import com.lxg.problem.clazz.loader.Loader;
import com.lxg.problem.clazz.v1.Cc;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: ClazzTest
 * @author: xuegangliu
 * @date: 2019/3/18 10:10
 ***************************/
@Slf4j
public class ClazzTest {

    @Test
    /**
     * 类不同内部信息的的加载顺序
     */
    public void testLoaderClass(){
        log.info("第一次加载 start");
        Loader t1 = new Loader();
        log.info("第一次加载 end");
        System.out.println(t1.name);
        t1.method1();
        t1.method3();


        log.info("第二次加载 start");
        Loader t2 = new Loader();
        log.info("第二次加载 end");
        t2.method1();
        System.out.println(t2.name);
        t2.method1();
        t1.method3();
    }

    @Test
    public void testMethod(){
        String text = "ok";
        log.info("before:{}",text);
        // 静态方法里重新指向新对象
        sayOne(text);
        log.info("end:{}",text);

    }

    public static void sayOne(String text){
        log.info("static text:{}",text);
        text=text+" hello!";
        log.info("static text=text+hello:{}",text);
    }

    @Test
    public void testV1(){
        log.info("第一次加载子类C start");
//        Cc c = new Cc();
        Cc c = new Cc("abc");
        c.say();
        Cc.ok();
        log.info("第一次加载子类C end");
        log.info("第二次加载子类C start");
        Cc c1 = new Cc("abc");
        c1.say();
        c1.ok();
        log.info("第二次加载子类C end");
    }
}
