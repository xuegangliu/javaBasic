package org.lxg.basic.base;

/**
 * @author: xuegangliu
 * @date: 9/3/2018 4:26 PM
 * @DES:
 * @version: v1.0
 */
public class BaseTest extends BaseAbstract{

    @Override
    void helloAbstract() {
        System.out.println("helloAbstract");
    }
}

class TestBaseInterface implements BaseInterface{

    @Override
    public void helloInterfaceTest() {
        System.out.println("helloTest");
    }
}
