package org.lxg.basic.patterns.bridge.bridge;

/**
 * 描述：牛排大类-牛排小类
 * @author coder-pig： 2017/02/05 下午2:11
 */
class BeefSteak extends AbstractSteak {

    BeefSteak(AbstractRations rations) { super(rations); }

    @Override public String sale() { return "牛扒"+ (rations == null ? "" : rations.rations()); }
}
