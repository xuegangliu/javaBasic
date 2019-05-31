package com.lxg.problem.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**************************
 * @description: SimpleTest
 * @author: xuegangliu
 * @date: 2019/3/19 16:07
 ***************************/
@Slf4j
public class SimpleTest {

    @Test
    public void testAutoBox(){
//        原始类型: boolean，char，byte，short，int，long，float，double
//        包装类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double
        log.info("Integer.Max:{},Integer.Min:{}",Integer.MAX_VALUE,Integer.MIN_VALUE);
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        log.info("a == b:{}",a == b);// false 两个引用没有引用同一对象
        log.info("a == c:{}",a == c);// true a自动拆箱成int类型再和c比较
        log.info("========================");
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        log.info("f1 == f2:{}",f1 == f2);
        log.info("f3 == f4:{}",f3 == f4);
    }

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

    @Test
    public void test111(){
        int i=5;
        if(i>1){
            System.out.println(1);
        }else if(i > 3){
            System.out.println(2);
        }
    }

    @Test
    public void testLt0Integer(){
        Integer i = -1;
        Integer a=500,b=500;
        log.info("{}",-1==i);
        log.info("{}",a==b);
    }

    @Test
    public void tt(){
        log.info("{}","nhh".getBytes());
    }

    @Test
    public void testMapKeySort(){
        Map map = new HashMap<String,String>();
        map.put("bankcard", "1");//银行卡号
        map.put("dsorderid", "1");//商户订单号
        map.put("idcard", "1");//证件号码
        map.put("idtype", "01");//证件类型
        map.put("merchno","1");//商户号
        map.put("ordersn", "1");//流水号
//			map.put("reqIp", matb.getAuthType());//请求IP
        map.put("username","1");//姓名
        map.put("version", "1");//版本号
        map.put("sceneCode","1");//版本号
        map.put("sCustomerName", "1");//版本号

        Set t1=map.keySet();
        Object[] ss= t1.toArray();

        for(Object s:ss){
            System.out.println(s.toString());
        }

//        Set t = map.keySet();
//        List[] ss= new List[]{Arrays.asList(t)};
//        Arrays.sort(ss);
//        for(List t1:ss){
//            System.out.println(t1);
//        }
    }


    public static void main(String[] args) {
        String[] input=new String[] {"idtype", "sCustomerName", "dsorderid", "merchno", "ordersn", "sceneCode", "idcard", "bankcard", "version", "username"};
        String[] keys=arraySort(input);
        for (String key : keys) {
            System.out.println(key);
        }
    }

    public static String[] arraySort(String[] input){
        for (int i=0;i<input.length-1;i++){
            for (int j=0;j<input.length-i-1;j++) {
                if(input[j].compareTo(input[j+1])>0){
                    String temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        return input;
    }

    @Test
    public void testUUID(){
        String uuid = UUID.randomUUID().toString();
        log.info("UUID.randomUUID().toString():{}",uuid);
    }

    @Test
    public void testSimpleOne(){
        /**
         * hashcode 与 equals
         */
        SimpleOne one = new SimpleOne(4);
        SimpleOne two = new SimpleOne(4);
        Set<Object> set = new HashSet<>();
        set.add(one);
        set.add(two);
        log.info("{}",one==two);
        log.info("{}",one.equals(two));
        log.info("{}",set.size());
    }

    class SimpleOne{
        private Integer age;

        SimpleOne(Integer age){
            this.age=age;
        }

        @Override
        public int hashCode() {
            return 1;
//            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof SimpleOne){
                if(this.age == ((SimpleOne) obj).age)
                    return true;
            }
            return super.equals(obj);
        }
    }
}
