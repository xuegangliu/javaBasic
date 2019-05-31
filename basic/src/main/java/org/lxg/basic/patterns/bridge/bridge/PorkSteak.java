package org.lxg.basic.patterns.bridge.bridge;

/**
 * 描述：牛排大类-猪扒小类
 * @author coder-pig： 2017/02/05 下午2:17
 */
class PorkSteak extends AbstractSteak {

    PorkSteak(AbstractRations rations) { super(rations); }

    @Override public String sale() { return "猪扒"+ (rations == null ? "" : rations.rations()); }
}
