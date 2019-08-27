package org.lxg.basic.patterns.decorator;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

class JinJu extends AbstractDecorator {

    AbstractTea tea;

    JinJu(AbstractTea tea) { this.tea = tea; }

    @Override public String getName() { return "金桔" + tea.getName(); }

    @Override public int price() { return 1 + tea.price(); }
}
