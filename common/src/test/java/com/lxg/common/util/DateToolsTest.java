package com.lxg.common.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**************************
 * @description: DateToolsTest
 * @author: xuegangliu
 * @date: 2019/3/6 15:20
 ***************************/
@Slf4j
public class DateToolsTest {

    @Test
    public void testDate1(){
        for(int i=1;i<=12;i++) {
            log.info("{}月第一天:{}",i,DateTools.getMonthFirstyDay(i,"yyyyMMdd"));
        }
        log.info("------------------------");
        for(int i=1;i<=12;i++) {
            log.info("{}月第一天:{}",i,DateTools.getMonthLastDay(i,"yyyyMMdd"));
        }

    }
}
