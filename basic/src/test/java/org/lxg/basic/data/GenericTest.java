package org.lxg.basic.data;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/14/2018 6:11 PM
 * @DES:
 * @version: v1.0
 */
public class GenericTest {

    // 泛型测试 通配符测试 改为T extends Integer,下边的代码会报错
//    class GenericeTest<T extends Integer> {
    class GenericeTest<T extends Object> {
        public void test1(T t){
            System.out.println(t.getClass().getCanonicalName());
        }

        public <T> boolean arryTest(T [] a,T t){
            boolean flag=false;
            for(T x:a){
                if(t==x) {
                    return true;
                }
            }
            return flag;
        }
    }

    @Test
    public void GenericeTest1(){
        GenericeTest<Boolean> booleanGenericeTest = new GenericeTest();
        GenericeTest<Byte> byteGenericeTest = new GenericeTest();
        GenericeTest<Short> shortGenericeTest = new GenericeTest();
        GenericeTest<Integer> integerGenericeTest = new GenericeTest();
        GenericeTest<Long> longGenericeTest = new GenericeTest();
        GenericeTest<Float> floatGenericeTest = new GenericeTest();
        GenericeTest<Double> doubleGenericeTest = new GenericeTest();
        GenericeTest<String> stringGenericeTest = new GenericeTest();
        int i=1;
        booleanGenericeTest.test1(true);
        byteGenericeTest.test1((byte)1);
        shortGenericeTest.test1((short)1);
        // 自动装箱机制   int-->Integer
        // 自动拆箱机制   Integer-->int
        integerGenericeTest.test1(i);
        longGenericeTest.test1((long)1);
        floatGenericeTest.test1((float)1.0);
        doubleGenericeTest.test1(1.1);
        stringGenericeTest.test1("test");
        String [] arr={"AA","BB"};
        System.out.println(stringGenericeTest.arryTest(arr,"AA"));
    }
}
