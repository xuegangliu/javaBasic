package org.lxg.basic.guice.aop;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class TestAopClass {

    @InvokeMe
    public int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TestAopModule());
        TestAopClass testClass = injector.getInstance(TestAopClass.class);
        int[][] intsArray = {
                {12, 3},
                {5, 0 },
                {3, 5}
        };
        for (int [] intArray : intsArray) {
            try {
                System.out.println(testClass.divide(intArray[0], intArray[1]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
