package org.lxg.basic.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.lxg.basic.guice.modules.AddModule;
import org.lxg.basic.guice.process.SampleProcess;
import org.lxg.basic.guice.providers.SampleProvider;

/**
 * Created by Administrator on 2017/7/18.
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
