package org.lxg.basic.patterns.proxy;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Agent implements FetchGoods{
    @Override public void fetchShoes() {
        Custom custom = new Custom();
        custom.fetchShoes();
        this.callCustom();
    }

    public void callCustom() { System.out.println("通知顾客过来取件！"); }

}
