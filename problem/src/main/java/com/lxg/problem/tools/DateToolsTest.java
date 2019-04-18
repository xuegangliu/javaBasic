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
    public final static SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public final static SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat df4 = new SimpleDateFormat("yyyyMMdd");

    public final String dateTest1="2018-12-01 13:15:20";
    public final String dateTest2="2018-12-01 01:15:20";
    public final String dateTest3="2018-12-01";
    public final String dateTest4="20180101";

    @Test
    public void test(){
        try {
            log.info("{}",df1.format(df1.parse(dateTest1)));
            log.info("{}",df2.format(df2.parse(dateTest2)));
            log.info("{}",df3.format(df3.parse(dateTest3)));
//            log.info("{}",df3.format(df3.parse(dateTest4)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
