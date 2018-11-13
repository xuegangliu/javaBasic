package org.lxg.basic.sample.inte;

/**
 * @author: xuegangliu
 * @date: 9/3/2018 4:25 PM
 * @DES:
 * @version: v1.0
 */
public interface BaseInterface {
    // 除public外无其它修饰符；无main方法(1.8以上 可以)
    void helloInterfaceTest();

    // 1.6 编译不通过;1.8可以
//    public static void main(String[] args) {
//        System.out.println("BaseInterface main()");
//    }
}
