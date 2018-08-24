package org.lxg.basic.patterns.facade;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:20 PM
 * @DES: 矩形
 * @version: v1.0
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("我是矩形 形状");
    }
}
