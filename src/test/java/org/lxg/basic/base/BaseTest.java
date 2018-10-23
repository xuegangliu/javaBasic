package org.lxg.basic.base;

/**
 * @author: xuegangliu
 * @date: 9/3/2018 4:26 PM
 * @DES:
 * @version: v1.0
 */
public class BaseTest{
    public static void main(String[] args) {
        new BaseNoAbstract();
        // 不能实例化抽象类
//        new BaseHasAbstract();
    }
}

class BaseNoAbstract extends BaseAbstract{

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
