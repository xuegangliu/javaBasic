package com.lxg.open.library.guice.di;

import com.google.inject.Provider;
import com.lxg.open.library.guice.di.base.DataProcessor;
import com.lxg.open.library.guice.di.base.impl.StringDataConcatenation;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class TestProviders implements Provider<DataProcessor> {
    @Override
    public DataProcessor get() {
        StringDataConcatenation processor = new StringDataConcatenation();
        processor.setTemplate("\n\t\tstr1 = %s\n\t\tstr2 = %s");
        return processor;
    }
}
