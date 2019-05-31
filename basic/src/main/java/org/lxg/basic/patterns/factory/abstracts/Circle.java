package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author xuegangliu
 *  8/24/2018 2:21 PM
 *  圆
 * @version: v1.0
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("我是圆形 形状");
    }
}
