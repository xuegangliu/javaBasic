package org.lxg.basic.patterns.bridge.bridge;

/**
 * 描述: 酱汁大类-加香草汁
 * Created by Administrator on 2017/2/5 0005.
 */
class XiangCaoSauces extends AbstractSauces {

    XiangCaoSauces(AbstractSteak steak) { super(steak); }

    @Override public String sauces() { return steak.sale() + "加香草汁"; }
}
