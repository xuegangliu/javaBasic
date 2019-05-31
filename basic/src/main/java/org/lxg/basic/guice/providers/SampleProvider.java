package org.lxg.basic.guice.providers;


import org.lxg.basic.guice.process.SampleProcess;

import javax.inject.Provider;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class SampleProvider implements Provider<SampleProcess> {
    @Override
    public SampleProcess get() {
        SampleProcess sampleProcess = new SampleProcess();
        return sampleProcess;
    }
}
