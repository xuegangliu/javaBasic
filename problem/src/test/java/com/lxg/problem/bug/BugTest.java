package com.lxg.problem.bug;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Test
    public void testPrefixOperators(){
        int i = 1,s=1;

        log.info("{}",i);
        int j = - - -i;  // Noncompliant; just use -i
        log.info("{}",i);
        int k = ~~~s;    // Noncompliant; same as i
        log.info("{}",i);
        int m = + +i;    // Noncompliant; operators are useless here
        log.info("{}",i);
        boolean b = false;
        boolean c = !!!b;   // Noncompliant

        log.info("j:{},k:{},m:{},c:{}",j,k,m,c);
    }

    @Test
    public void testAtomicInteger(){
        AtomicInteger aInt1 = new AtomicInteger(0);
        AtomicInteger aInt2 = new AtomicInteger(0);

        if (aInt1.equals(aInt2)) {
            log.info("aInt1.equals(aInt2)");
        }  // Noncompliant

        if (aInt1.get() == aInt2.get()) {
            log.info("aInt1.get() == aInt2.get()");
        }
    }
}
