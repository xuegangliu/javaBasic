package org.lxg.basic.patterns.bridge.bridge;

/**
 * 描述：牛排大类
 * @author coder-pig： 2017/02/05 下午1:59
 */
abstract class AbstractSteak {
    AbstractRations rations;

    AbstractSteak(AbstractRations rations) { this.rations = rations; }

    /**
     * sale
     * @return
     */
    abstract String sale();
}
