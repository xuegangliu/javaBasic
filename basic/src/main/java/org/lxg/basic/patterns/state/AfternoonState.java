package org.lxg.basic.patterns.state;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class AfternoonState implements State {
    @Override
    public void doSomeThing() {
        System.out.println("下午学习！");
    }
}
