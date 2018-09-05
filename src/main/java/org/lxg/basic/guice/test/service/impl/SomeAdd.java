package org.lxg.basic.guice.test.service.impl;


import org.lxg.basic.guice.test.service.Add;

/**
 * Created by Administrator on 2017/7/18.
 */
public class SomeAdd implements Add {
    @Override
    public int getAddTogether(int a, int b) {
        return a+b;
    }
}
