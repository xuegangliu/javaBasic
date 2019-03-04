package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:36 PM
 * @DES:
 * @version: v1.0
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
