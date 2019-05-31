package org.lxg.basic.patterns.decorator;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

class LemonTea extends AbstractTea {
    LemonTea() { setName("柠檬茶"); }
    @Override public int price() { return 3; }
}
