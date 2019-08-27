package org.lxg.basic.patterns.bridge.bridge;

/**
 * 描述：牛排大类-鸡排小类
 * @author coder-pig： 2017/02/05 下午2:11
 */
class ChickenSteak extends AbstractSteak {

    ChickenSteak(AbstractRations rations) { super(rations); }

    @Override public String sale() { return "鸡扒"+ (rations == null ? "" : rations.rations()); }
}
