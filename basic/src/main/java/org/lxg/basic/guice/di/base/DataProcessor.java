package org.lxg.basic.guice.di.base;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public interface DataProcessor {

    /**
     * process
     * @param first
     * @param second
     * @return
     */
    String process(String first, String second);
}
