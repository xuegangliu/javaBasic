package com.lxg.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**************************
 * @description: DateTools
 * @author: xuegangliu
 * @date: 2019/3/6 14:20
 ***************************/
public class DateTools {

    /**
     * 获取当年的月份第一天
     *
     * @param month 第几个月的第一天
     * @param format 返回的格式
     * @return 返回当年的月份 例: "20180101"
     */
    public static String getMonthFirstyDay(int month,String format){
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return df.format(calendar.getTime());
    }

    /**
     * 获取当年的月份的最后一天
     *
     * @param month 第几个月
     * @param format 返回的格式
     * @return 返回当年的月份的最后一天 例: "20180131"
     */
    public static String getMonthLastDay(int month,String format){
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return df.format(calendar.getTime());
    }
}
