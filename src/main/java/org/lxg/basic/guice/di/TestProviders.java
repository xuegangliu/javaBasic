package org.lxg.basic.guice.di;

import com.google.inject.Provider;
import org.lxg.basic.guice.di.base.DataProcessor;
import org.lxg.basic.guice.di.base.impl.StringDataConcatenation;

public class TestProviders implements Provider<DataProcessor> {
    @Override
    public DataProcessor get() {
        StringDataConcatenation processor = new StringDataConcatenation();
        processor.setTemplate("\n\t\tstr1 = %s\n\t\tstr2 = %s");
        return processor;
    }
}
