package org.lxg.basic.patterns.observer.pull;

/**
 * @author xuegangliu
 * @date 2017/3/7 0007.
 */
public class CoderPig extends AbstractOfficialAccount {
    /** 更新的文章 */
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void update(String msg) {
        this.msg = msg;
        System.out.println("公众号更新了文章：" + msg);
        this.notifyUse();   //通知用户有更新
    }
}
