package com.lxg.core.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**************************
 *  CoreUtilsTest
 * @author xuegangliu
 *  2019/2/27 10:42
 ***************************/
@Slf4j
public class CoreUtilsTest {

//    @Test
    public void testAssert(){
        AbstractAssert.isTrue(false);
    }


    @Test
    public void testStringEnd(){
        System.out.println(File.separator);
        System.out.println("D:\\workspace\\lxg\\javaBasic\\tmp\\test.doc".endsWith(File.separator));
    }

    @Test
    public void testLog(){
        log.info("this is log info ....");
        log.error("this is log error ....");
        log.debug("this is log debug ....");
        log.info("{},{}",1,2);
    }
}
