package org.lxg.basic.guice.test.service.impl;


import org.lxg.basic.guice.test.service.Add;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class SampleAdd implements Add {

    @Override
    public int getAddTogether(int a, int b) {
        return a+b;
    }
}
