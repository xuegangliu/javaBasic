package org.lxg.basic.patterns.strategy;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class Context {
    private Compute compute;

    public Context() { compute = new Add(); }

    public void setCompute(Compute compute) { this.compute = compute; }

    public void calc(int first, int second) { System.out.println(compute.compute(first, second)); }

}
