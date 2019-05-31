package org.lxg.basic.guice.di;

import com.google.inject.Provider;
import org.lxg.basic.guice.di.base.DataProcessor;
import org.lxg.basic.guice.di.base.impl.StringDataConcatenation;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class TestProviders implements Provider<DataProcessor> {
    @Override
    public DataProcessor get() {
        StringDataConcatenation processor = new StringDataConcatenation();
        processor.setTemplate("\n\t\tstr1 = %s\n\t\tstr2 = %s");
        return processor;
    }
}
