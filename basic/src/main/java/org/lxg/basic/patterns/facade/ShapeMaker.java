package org.lxg.basic.patterns.facade;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:23 PM
 * @DES: 对外形状
 * @version: v1.0
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
