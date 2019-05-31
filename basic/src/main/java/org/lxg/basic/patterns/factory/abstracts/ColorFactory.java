package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:35 PM
 * @DES:
 * @version: v1.0
 */
public class ColorFactory extends AbstractFactory {
    private final String RED="RED";
    private final String GREEN="GREEN";
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(RED.equals(color)){
            return new Red();
        } else if(GREEN.equals(color)){
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

}
