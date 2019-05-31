package org.lxg.basic.guice.aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class TestAopModule extends AbstractModule {
    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(),Matchers.annotatedWith(InvokeMe.class), new TestAopInvoker());
    }
}
