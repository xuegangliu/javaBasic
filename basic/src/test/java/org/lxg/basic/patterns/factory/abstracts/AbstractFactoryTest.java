package org.lxg.basic.patterns.factory.abstracts;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:37 PM
 * @DES:
 * @version: v1.0
 */
public class AbstractFactoryTest {

    @Test
    public void abstractFactoryTest(){
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //获取形状为 Circle 的对象
        Shape circle = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        circle.draw();
        //获取形状为 Rectangle 的对象
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        //调用 Rectangle 的 draw 方法
        rectangle.draw();

        //获取颜色为 Red 的对象
        Color red = colorFactory.getColor("RED");
        //调用 Red 的 fill 方法
        red.fill();
        //获取颜色为 Green 的对象
        Color green = colorFactory.getColor("Green");
        //调用 Green 的 fill 方法
        green.fill();
    }
}
