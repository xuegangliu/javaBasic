package com.lxg.open.library.guice.providers;


import com.lxg.open.library.guice.process.SampleProcess;

import javax.inject.Provider;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class SampleProvider implements Provider<SampleProcess> {
    @Override
    public SampleProcess get() {
        SampleProcess sampleProcess = new SampleProcess();
        return sampleProcess;
    }
}
