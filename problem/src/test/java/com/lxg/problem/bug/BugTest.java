package com.lxg.problem.bug;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**************************
 * @description: BugTest
 * @author: xuegangliu
 * @date: 2019/4/17 9:40
 * @since: jdk1.8+
 ***************************/
@Slf4j
public class BugTest {

    @Test
    public void testDateFormat() throws ParseException {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
        String result = new SimpleDateFormat("YYYY/MM/dd").format(date);   //Noncompliant; yields '2016/12/31'
        log.info("{}",result);

        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
        String result1 = new SimpleDateFormat("yyyy/MM/dd").format(date1);   //Yields '2015/12/31' as expected
        log.info("{}",result1);

        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
        String result2 = new SimpleDateFormat("YYYY-ww").format(date2);  //compliant, 'Week year' is used along with 'Week of year'. result = '2016-01'
        log.info("{}",result2);
    }

    @Test
    public void testIncremented(){
        int i=0,j=0;
        log.info("i++:{}",i++);
        log.info("i++ end i:{}",i);
        log.info("++j:{}",++j);
        log.info("++j end j:{}",j);
    }
}
