package com.lxg.open.library.guice.test.service.impl;


import com.lxg.open.library.guice.test.service.Add;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class SomeAdd implements Add {
    @Override
    public int getAddTogether(int a, int b) {
        return a+b;
    }
}
