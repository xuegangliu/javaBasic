package com.lxg.problem.tools;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**************************
 * @description: DateToolsTest
 * @author: xuegangliu
 * @date: 2019/4/15 13:14
 * @since: jdk1.8+
 ***************************/
@Slf4j
public class DateToolsTest {
    public final static SimpleDateFormat DF1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat DF2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public final static SimpleDateFormat DF3 = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat DF4 = new SimpleDateFormat("yyyyMMdd");

    public final String dateTest1="2018-12-01 13:15:20";
    public final String dateTest2="2018-12-01 01:15:20";
    public final String dateTest3="2018-12-01";
    public final String dateTest4="20180101";

    @Test
    public void test(){
        try {
            log.info("{}",DF1.format(DF1.parse(dateTest1)));
            log.info("{}",DF2.format(DF2.parse(dateTest2)));
            log.info("{}",DF3.format(DF3.parse(dateTest3)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
