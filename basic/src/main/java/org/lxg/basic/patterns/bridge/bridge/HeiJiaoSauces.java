package org.lxg.basic.patterns.bridge.bridge;

/**
 * 描述: 酱汁大类-加黑椒汁
 * Created by Administrator on 2017/2/5 0005.
 */
class HeiJiaoSauces extends AbstractSauces {

    HeiJiaoSauces(AbstractSteak steak) { super(steak); }

    @Override public String sauces() { return steak.sale() + "加黑椒汁"; }
}
