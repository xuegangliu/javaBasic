package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:34 PM
 * @DES:
 * @version: v1.0
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
