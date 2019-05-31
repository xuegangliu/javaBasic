package org.lxg.basic.patterns.builder;

import org.junit.Test;

/**
 * @author xuegangliu
 *  8/14/2018 1:13 PM
 *
 * @version: v1.0
 */
public class BuilderTest {

    @Test
    public void gameTest(){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Character character =  director.createCharacter("男","硬汉脸","牛仔装");
        System.out.println(character.showMsg());
    }
}
