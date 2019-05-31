package org.lxg.basic.patterns.proxy;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class Custom implements FetchGoods{
    @Override public void fetchShoes() { System.out.println("拿货"); }
}
