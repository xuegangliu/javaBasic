package org.lxg.basic.guice.di.base.impl;

import com.google.inject.Inject;
import com.lxg.di.base.DataProcessor;
import com.lxg.di.base.SomeService;

public class TestMethodDiServiceImpl implements SomeService {
    DataProcessor processor;

    @Override
    public String processData(final String first, final String second) {

        //do something
        String result = processor.process(first, second);
        //do something
        return result;
    }

    @Inject
    public void testInjection(DataProcessor outerProcessor) {

        this.processor = outerProcessor;
    }
}
