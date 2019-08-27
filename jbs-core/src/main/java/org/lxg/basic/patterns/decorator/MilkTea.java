package org.lxg.basic.patterns.decorator;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

class MilkTea extends AbstractTea {
    MilkTea() { setName("奶茶"); }
    @Override public int price() { return 5; }
}
