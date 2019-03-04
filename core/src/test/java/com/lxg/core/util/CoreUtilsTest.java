package com.lxg.core.util;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.io.File;

/**************************
 * @description: CoreUtilsTest
 * @author: xuegangliu
 * @date: 2019/2/27 10:42
 ***************************/
@Log4j2
public class CoreUtilsTest {

    @Test
    public void testAssert(){
        Assert.isTrue(false);
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
    }
}
