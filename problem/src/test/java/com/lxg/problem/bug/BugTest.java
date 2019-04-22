package com.lxg.problem.bug;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

    @Test
    public void testBigDecimal(){
        double d = 1.1;
        BigDecimal bd1 = new BigDecimal(d); // Noncompliant; see comment above
        log.info("bd1:{}",bd1);
        BigDecimal bd2 = new BigDecimal(1.1); // Noncompliant; same result
        log.info("bd2:{}",bd2);

        BigDecimal bd3 = BigDecimal.valueOf(d); // Compliant
        BigDecimal bd4 = new BigDecimal("1.1"); // using String constructor will result in precise value
        log.info("bd3:{}",bd3);
        log.info("bd4:{}",bd4);

        int i = 42;
        double s = Double.longBitsToDouble(i);  // Noncompliant
        log.info("{}",s);
    }

    @Test
    public void testCompareTo(){
        String a1 = "ABCDDFD";
        String a2 = "ABCDSDFD";

        if (a1.compareTo(a2) == -1) {  // Noncompliant
            log.info("a1.compareTo(a2) == -1");
        }

        if (a1.compareTo(a2) < 0) {
            log.info("{}",a1.compareTo(a2));
            log.info("a1.compareTo(a2) < 0");
        }
    }

    @Test
    public void testInstanceof(){
//        Integer age = null;
        Integer age = 1;
        String name = null;
        log.info("{},{}",age,(age instanceof Number));
        log.info("{},{}",name,(name instanceof String));
    }

    @Test
    public void testInterruptedException(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        log.info("111");
//                        Thread.sleep(3000);
                        // do stuff
                        throw new InterruptedException("123");
                    }
                }catch (InterruptedException e) { // Noncompliant; logging is not enough
                    log.info("Interrupted:{}",e);

                    // Restore interrupted state...
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.start();
        t.start();
        t.start();
        t.start();
        t.start();
    }

    @Test
    public void testCreateARandom() throws NoSuchAlgorithmException {
        Random rand = SecureRandom.getInstanceStrong();  // SecureRandom is preferred to Random
        for(int i=1;i<=10;i++){
            log.info("{}",rand.nextInt());
        }
    }

    @Test
    public void testListToArray(){
        List<String> list = new ArrayList();
        for(int i=1;i<=10;i++){
            list.add(i+" test");
        }
        String [] arrays = list.toArray(new String[0]);
//        String [] arraysErr = (String[]) list.toArray(); // The method is error
        int len = arrays.length;
        for(int i=0;i<len;i++){
            log.info(arrays[i]);
//            log.info(arraysErr[i]);
        }
    }

    // sonar java rules to 40
}
