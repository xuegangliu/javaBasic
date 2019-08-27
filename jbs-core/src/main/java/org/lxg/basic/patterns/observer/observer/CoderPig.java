package org.lxg.basic.patterns.observer.observer;

import java.util.Observable;

/**
 * @author xuegangliu
 *  2017/3/7 0007.
 */
public class CoderPig extends Observable {

    private String msg;

    public String getMsg() { return msg; }

    public void update(String msg) {
        this.msg = msg;
        System.out.println("公众号更新了文章：" + msg);
        //这句话必不可少，通知改变
        this.setChanged();
        //这里用推的方式
        this.notifyObservers(this.msg);
    }
}
