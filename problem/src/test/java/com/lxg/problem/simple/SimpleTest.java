package com.lxg.problem.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**************************
 * @description: SimpleTest
 * @author: xuegangliu
 * @date: 2019/3/19 16:07
 ***************************/
@Slf4j
public class SimpleTest {

    @Test
    public void testBasicStruct(){
//        基本类型	大小(字节)	默认值	封装类
//        byte	1	(byte)0	Byte
//        short	2	(short)0	Short
//        int	4	0	Integer
//        long	8	0L	Long
//        float	4	0.0f	Float
//        double	8	0.0d	Double
//        boolean	-	false	Boolean
//        char	2	\u0000(null)	Character
//        void	-	-	Void
        int a1 = 1800000000;
        int a2 = new Integer(1800000000);
        int a3 = a1;
        int a4 = 1800000000;

        log.info("a1==a2:{}",(a1==a2));
        log.info("a1==a3:{}",(a1==a3));
        log.info("a1==a4:{}",(a1==a4));

        log.info("2 << 2:{}",(2 << 2));

    }

    @Test
    public void testAdd(){
        int i=0;
        int j=0;
        log.info("i++:{}",(i++));
        log.info("++j:{}",(++j));
    }

    @Test
    public void testFinal(){
        final int t = 5;
        testT(t);
    }

    public void testT(int t){
        log.info("{}",t);
        ++t;
        log.info("{}",t);
    }

    @Test
    public void test11(){
        Integer t = 101;
        Double t1 = 101.0000001;
        Long t2 = 101l;
        String t3 = "101.0000001";
        log.info("{}",new BigDecimal(t1));
        log.info("{},{},{}",t.getClass(),t,new BigDecimal(t).divide(new BigDecimal(100)));
        log.info("{},{}",t1,new BigDecimal(t1).divide(new BigDecimal(100)));
        log.info("{},{}",t2,new BigDecimal(t2).divide(new BigDecimal(100)));
        log.info("{},{}",t3,new BigDecimal(t3).divide(new BigDecimal(100)));

    }

    @Test
    public void testBigDecimalNull(){
        BigDecimal t = new BigDecimal("");
        log.info("{}",t);
    }

    /**
     * if 跳出
     */
    @Test
    public void testIfBreak(){
        log.info("start");
        ok:if(1<10){
            log.info("{}","1<10");
            if(5<10) {
                log.info("{}", "5<10");
                break ok;
            }
            if(6<10){
                log.info("{}","6<10");
            }
        }
        log.info("end");
    }
}
