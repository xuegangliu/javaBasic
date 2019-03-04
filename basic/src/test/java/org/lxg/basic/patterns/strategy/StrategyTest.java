package org.lxg.basic.patterns.strategy;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/28/2018 3:40 PM
 * @DES:
 * @version: v1.0
 */
public class StrategyTest {

    @Test
    public void strategyTest(){
        Context context = new Context();

        context.setCompute(new Add());
        context.calc(1,2);

        context.setCompute(new Sub());
        context.calc(3,4);

        context.setCompute(new Mul());
        context.calc(5,6);

        context.setCompute(new Div());
        context.calc(7,8);
    }

    @Test
    public void computeTest(){
        System.out.println("计算：1 + 1 = " + compute("+", 1, 1));
        System.out.println("计算：1 - 1 = " + compute("-", 1, 1));
        System.out.println("计算：1 * 1 = " + compute("*", 1, 1));
        System.out.println("计算：1 / 1 = " + compute("/", 1, 1));
    }

    public static float compute(String operator, int first, int second) {
        switch (operator) {
            case "+": return first + second;
            case "-": return first - second;
            case "*": return first * second;
            case "/": return first / second;
            default: return 0.0f;
        }
    }
}
