package org.lxg.basic.patterns.state;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Context {
    public void setState(State state) {
        System.out.println("状态改变");
        state.doSomeThing();
    }
}
