package org.lxg.basic.patterns.strategy;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Mul implements Compute{
    @Override public String compute(int first, int second) {
        return "输出结果：" + first + " * " + second + " = " + (first * second);
    }
}
