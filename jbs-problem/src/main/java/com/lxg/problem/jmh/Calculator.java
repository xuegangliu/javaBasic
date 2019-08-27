package com.lxg.problem.jmh;

/**
 * Calculator
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/21
 * @since 1.8
 **/
public interface Calculator {
    /**
     * calculate sum of an integer array
     * @param numbers
     * @return
     */
    public long sum(int[] numbers);

    /**
     * shutdown pool or reclaim any related resources
     */
    public void shutdown();
}
