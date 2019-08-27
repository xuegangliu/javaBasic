package org.lxg.basic.jdk8;

import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author xuegangliu
 *  8/21/2018 10:57 AM
 *
 * @version: v1.0
 */
public class DateTest {

    @Test
    public void localDateTest(){
        // 取当前日期：
        LocalDate today = LocalDate.now(); // -> 2014-12-24
        System.out.println("LocalDate.now()->"+today);

        // 根据年月日取日期，12月就是12：
        LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25
        System.out.println("LocalDate.of(2014, 12, 25)->"+crischristmas);

        // 根据字符串取：
        LocalDate endOfFeb = LocalDate.parse("2014-02-28"); // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        System.out.println("LocalDate.parse(\"2014-02-28\")->"+endOfFeb);
//        LocalDate.parse("2014-02-29"); // 无效日期无法通过：DateTimeParseException: Invalid date
//        AbstractAssert.fail();


        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with( TemporalAdjusters.firstDayOfMonth()); // 2014-12-01
        System.out.println("today.with( TemporalAdjusters.firstDayOfMonth())->"+firstDayOfThisMonth);

        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2014-12-02
        System.out.println("today.withDayOfMonth(2)->"+secondDayOfThisMonth);

        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
        System.out.println("today.with(TemporalAdjusters.lastDayOfMonth())->"+lastDayOfThisMonth);

        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2015-01-01
        System.out.println("lastDayOfThisMonth.plusDays(1)->"+firstDayOf2015);

        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth( DayOfWeek.MONDAY)); // 2015-01-05
        System.out.println("LocalDate.parse(\"2015-01-01\").with(TemporalAdjusters.firstInMonth( DayOfWeek.MONDAY))->"+firstMondayOf2015);
    }

    @Test
    public void localTimeTest(){
        // LocalTime包含毫秒
        LocalTime now = LocalTime.now(); // 11:09:09.240
        System.out.println("LocalTime.now():"+now);

        // 清除毫秒数
        LocalTime now1 = LocalTime.now().withNano(0); // 11:09:09
        System.out.println("LocalTime.now().withNano(0):"+now1);

        // 构造时间
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
        System.out.println("LocalTime.of(0, 0, 0):"+zero);
        System.out.println("LocalTime.parse(\"12:00:00\"):"+mid);
    }
}
