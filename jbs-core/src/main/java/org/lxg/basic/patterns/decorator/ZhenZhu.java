package org.lxg.basic.patterns.decorator;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

class ZhenZhu extends AbstractDecorator {

    AbstractTea tea;

    ZhenZhu(AbstractTea tea) { this.tea = tea; }

    @Override public String getName() { return "珍珠" + tea.getName(); }

    @Override public int price() { return 2 + tea.price(); }
}
