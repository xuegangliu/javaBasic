package com.lxg.open.library.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lxg.open.library.guice.modules.AddModule;
import com.lxg.open.library.guice.process.SampleProcess;
import com.lxg.open.library.guice.providers.SampleProvider;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class ProviderTest {
    public static void main(String[] args) {
        Injector inject =  Guice.createInjector(new AddModule() {
            @Override
            public void configure(Binder binder) {
                binder.bind(SampleProcess.class).toProvider(SampleProvider.class);
            }
        });

        SampleProcess sampleProcess =
                inject.getInstance(SampleProcess.class);
        sampleProcess.start();
        sampleProcess.end();
    }
}
