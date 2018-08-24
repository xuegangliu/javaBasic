package org.lxg.basic.patterns.facade;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:21 PM
 * @DES: 正方形
 * @version: v1.0
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("我是正方形  形状");
    }
}
