package org.lxg.basic.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**************************
 *  DateTest
 * @author xuegangliu
 *  2019/3/6 9:06
 ***************************/
@Slf4j
public class DateTest {

    @Test
    public void test1(){
        int pre=1;
        Calendar cale = Calendar.getInstance();
        log.info("Calendar.MONTH:{}",Calendar.MONTH);
        int currentMonth = cale.get(Calendar.MONTH) + 1;
        log.info("currentMonth:{}",currentMonth);
        int returnMonth = currentMonth + pre;
        if (returnMonth <= 0) {
            returnMonth = returnMonth + 12;
        } else if (returnMonth > 12) {
            returnMonth = returnMonth % 12;
        }

        log.info("returnMonth:{}",returnMonth);
    }

    @Test
    public void test2(){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        calendar.set(2018,0,1);
        log.info("{}",df.format(calendar.getTime()));
    }
}
