package org.lxg.basic.guice.di.base.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.lxg.basic.guice.di.NotLeaveString;
import org.lxg.basic.guice.di.base.DataProcessor;
import org.lxg.basic.guice.di.base.SomeService;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class TestCustomAnnotationServiceImpl implements SomeService {
    @Inject
    DataProcessor processor;

    @Inject
    String separator;

    @Inject
    String anotherSeparator;

    @Inject
    @Named("Not leave string")
    String anotherString;

    @Inject
    @NotLeaveString
    String defaultString;
    @Override
    public String processData(final String first, final String second) {

        //do something
        String result = processor.process(anotherString + separator, defaultString + anotherSeparator);
        //do something
        return result;
    }


}
