package com.lxg.problem.clazz;

import com.lxg.problem.clazz.loader.Loader;
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

}
