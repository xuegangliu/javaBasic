package org.lxg.basic.patterns.factory.method;


/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:34 PM
 * @DES:
 * @version: v1.0
 */
public class ShapeFactory  {
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
}
