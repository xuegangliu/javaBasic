package org.lxg.basic.patterns.prototype;

import org.junit.Test;

import java.io.IOException;

/**
 * @author xuegangliu
 *  8/30/2018 10:48 AM
 *
 * @version: v1.0
 */
public class PrototypeTest {

    @Test
    public void prototypeTest(){
        Assets assets1 = new Assets(100,new Money("人民币"),"现金");
        Assets assets2 = (Assets) assets1.clone();

        System.out.println("assets1.equals(assets2)：" + assets1.equals(assets2));
        System.out.println("assets1 == assets2：" + (assets1 == assets2));

        System.out.println("assets1.getClass == asset2.getClass ：" + (assets1.getClass() == assets2.getClass()));

        System.out.println("assets1.getMoney() == assets2.getMoney() ：" + (assets1.getMoney() == assets2.getMoney()));

        System.out.println("Assets1：" + assets1.toString());
        System.out.println("Assets2：" + assets2.toString());

        assets1.setAmount(200);
        System.out.println("Assets1：" + assets1.toString());
        System.out.println("Assets2：" + assets2.toString());

        assets2.getMoney().setType("美金");
        System.out.println("Assets1：" + assets1.toString());
        System.out.println("Assets2：" + assets2.toString());
    }

    @Test
    public void prototypeTest2(){
        AssetsS assetsS1 = new AssetsS(100,new MoneyS("人民币"),"现金");
        try {
            AssetsS assetsS2 = assetsS1.deepClone();    //序列化深克隆
            //...其他代码
            System.out.println(assetsS1.toString());
            System.out.println(assetsS2.toString());
            System.out.println(assetsS1.equals(assetsS2));
            System.out.println(assetsS1==assetsS2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
