package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author xuegangliu
 *  8/24/2018 2:33 PM
 *
 * @version: v1.0
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("我是绿色");
    }
}
