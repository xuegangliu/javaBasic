package org.lxg.basic.patterns.state;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class MorningState implements State {
    @Override
    public void doSomeThing() {
        System.out.println("早上赖床！");
    }
}
