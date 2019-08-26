package com.lxg.open.library.guice.di.base.impl;

import com.google.inject.Inject;
import com.lxg.open.library.guice.di.base.DataProcessor;
import com.lxg.open.library.guice.di.base.SomeService;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class TestConstructorDiServiceImpl implements SomeService {
    DataProcessor processor;

    @Inject
    public TestConstructorDiServiceImpl(DataProcessor outerProcessor) {
        this.processor = outerProcessor;
    }

        @Override
    public String processData(final String first, final String second) {

        //do something
        String result = processor.process(first, second);
        //do something
        return result;
    }
}
