package org.lxg.basic.guice.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class TestAopInvoker implements MethodInterceptor {

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        Object [] arguments = invocation.getArguments();
        if ( Integer.parseInt(arguments[1]+"") == 0) {
            System.out.println("What are you doing now?!!");
            throw new IllegalArgumentException("Never divide by zero");
        }
        return invocation.proceed();
    }
}
