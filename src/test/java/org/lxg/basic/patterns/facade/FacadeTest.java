package org.lxg.basic.patterns.facade;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/24/2018 2:22 PM
 * @DES:
 * @version: v1.0
 */
public class FacadeTest {

    @Test
    public void shapeTest(){
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
