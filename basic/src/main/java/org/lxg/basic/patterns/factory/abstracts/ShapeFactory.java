package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:34 PM
 * @DES:
 * @version: v1.0
 */
public class ShapeFactory extends AbstractFactory {
    private final String CIRCLE="CIRCLE";
    private final String RECTANGLE="RECTANGLE";

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(CIRCLE.equals(shapeType)){
            return new Circle();
        } else if(RECTANGLE.equals(shapeType)){
            return new Rectangle();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
