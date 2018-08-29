package org.lxg.basic.patterns.responsechain;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/29/2018 6:20 PM
 * @DES:
 * @version: v1.0
 */
public class ResponsechainTest {

    @Test
    public void responsechainTest(){
        Brother brother = new Brother();
        Father father = new Father();
        Mother mother = new Mother();

        //指定下家
        brother.setNextHandler(father);
        father.setNextHandler(mother);

        brother.handlerRequest("要钱",1200);
    }
}
