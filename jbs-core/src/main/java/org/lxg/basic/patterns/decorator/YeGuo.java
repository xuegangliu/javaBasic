package org.lxg.basic.patterns.decorator;

/**
 * Created by Administrator on 2017/1/21 0021.
 */

class YeGuo extends AbstractDecorator {

    AbstractTea tea;

    YeGuo(AbstractTea tea) { this.tea = tea; }

    @Override public String getName() { return "椰果" + tea.getName(); }

    @Override  public int price() { return 2 + tea.price(); }
}
