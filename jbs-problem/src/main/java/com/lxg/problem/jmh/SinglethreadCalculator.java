package com.lxg.problem.jmh;

/**
 * SinglethreadCalculator
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/21
 * @since 1.8
 **/
public class SinglethreadCalculator implements Calculator {

    @Override
    public long sum(int[] numbers) {
        long total = 0L;
        for (int i : numbers) {
            total += i;
        }
        return total;
    }

    @Override
    public void shutdown() {
        // nothing to do
    }
}