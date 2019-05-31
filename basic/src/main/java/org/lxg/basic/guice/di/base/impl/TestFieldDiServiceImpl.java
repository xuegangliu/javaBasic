package org.lxg.basic.guice.di.base.impl;

import com.google.inject.Inject;
import org.lxg.basic.guice.di.base.DataProcessor;
import org.lxg.basic.guice.di.base.SomeService;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class TestFieldDiServiceImpl implements SomeService {
    @Inject
    DataProcessor processor;
    @Inject
    String unknownString;
    @Inject
    String defaultString = " default ";
    @Inject
    int anInt;
    @Inject
    Object unknownObject;
    @Override
    public String processData(final String first, final String second) {

        //do something
        String result = processor.process(anInt + unknownString, defaultString + unknownObject.toString());
        //do something
        return result;
    }


}
