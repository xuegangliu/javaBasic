package org.lxg.basic.patterns.factory.method;

import org.junit.Test;

/**
 * @author xuegangliu
 *  8/24/2018 2:46 PM
 *
 * @version: v1.0
 */
public class ShapeFactoryTest {

    @Test
    public void factoryTest(){
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        shape2.draw();
    }
}
