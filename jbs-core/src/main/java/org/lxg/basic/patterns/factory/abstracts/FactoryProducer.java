package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author xuegangliu
 *  8/24/2018 2:36 PM
 *
 * @version: v1.0
 */
public class FactoryProducer {
    public final static String SHAPE="SHAPE";
    public final static String COLOR="COLOR";
    public static AbstractFactory getFactory(String choice){
        if(SHAPE.equals(choice)){
            return new ShapeFactory();
        } else if(COLOR.equals(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
