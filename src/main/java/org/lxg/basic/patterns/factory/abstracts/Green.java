package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:33 PM
 * @DES:
 * @version: v1.0
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("我是绿色");
    }
}
