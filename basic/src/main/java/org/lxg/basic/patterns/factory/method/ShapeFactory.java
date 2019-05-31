package org.lxg.basic.patterns.factory.method;


/**
 * @author xuegangliu
 *  8/24/2018 2:34 PM
 *
 * @version: v1.0
 */
public class ShapeFactory  {
    private final String CIRCLE="CIRCLE";
    private final String RECTANGLE="RECTANGLE";
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
}
