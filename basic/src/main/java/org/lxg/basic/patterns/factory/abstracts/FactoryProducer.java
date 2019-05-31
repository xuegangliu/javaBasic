package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:36 PM
 * @DES:
 * @version: v1.0
 */
public class FactoryProducer {
    private final static String SHAPE="SHAPE";
    private final static String COLOR="COLOR";
    public static AbstractFactory getFactory(String choice){
        if(SHAPE.equals(choice)){
            return new ShapeFactory();
        } else if(COLOR.equals(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
