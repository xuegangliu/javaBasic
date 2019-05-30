package com.lxg.common.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: MD5Test
 * @author: xuegangliu
 * @date: 2019/3/18 10:59
 ***************************/
@Slf4j
public class MD5Test {

    @Test
    public void testMd5(){
        log.info(Md5Tools.md5("aaabb"));
        log.info(Md5Tools.md5("aaabb"));
    }

    @Test
    public void testAddString(){
        String a = "1",b = "1";
        for ( ; a.length() < 32 ; a = "0" + a) continue;
        for (int i=0 ; i < 32 - b.length() ; i++){
            b = "0" + b;
        }
        System.out.println("a:"+a.length());
        log.info(a);
        System.out.println("b:"+b.length());
        log.info(b);
        for (int i= b.length() ; 0 < 32 - b.length() ; i++){
            b = "0" + b;
        }
        log.info(b);

    }
}
