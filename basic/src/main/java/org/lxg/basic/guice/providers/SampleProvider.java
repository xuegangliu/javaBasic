package org.lxg.basic.guice.providers;


import org.lxg.basic.guice.process.SampleProcess;

import javax.inject.Provider;

/**
 * Created by Administrator on 2017/7/18.
 */
public class SampleProvider implements Provider<SampleProcess> {
    @Override
    public SampleProcess get() {
        SampleProcess sampleProcess = new SampleProcess();
        return sampleProcess;
    }
}
