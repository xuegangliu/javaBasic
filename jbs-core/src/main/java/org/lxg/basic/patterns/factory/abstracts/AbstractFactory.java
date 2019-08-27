package org.lxg.basic.patterns.factory.abstracts;

/**
 * @author xuegangliu
 *  8/24/2018 2:34 PM
 *
 * @version: v1.0
 */
public abstract class AbstractFactory {

    /**
     * getColor
     * @param color
     * @return
     */
    public abstract Color getColor(String color);

    /**
     * getShape
     * @param shape
     * @return
     */
    public abstract Shape getShape(String shape) ;
}
