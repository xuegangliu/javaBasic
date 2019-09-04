package com.lxg.open.library.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lxg.open.library.guice.modules.AddModule;
import com.lxg.open.library.guice.test.service.Add;

/**
 * @author xuegangliu
 *  2017/7/18.
 */
public class ModuleTest {

//    public Add add;
//
//    @Inject//将实例注入到客户端
//    public Test(Add add){
//        this.add = add;
//    }

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        //它只关心如何创建 （Creating）和维护 (Maintaining) 对象（生命周期）
        Injector injector = Guice.createInjector(new AddModule());
        //将会创建并返回一个 SimpleAdd 类型的实例-->实际上是通过 AddModule.configure()

        // 一个接口多个实现类
        // Named注释
        Add add3 = (Add)injector.getInstance(Add.class);
        Add add4 = injector.getInstance(Add.class);
        System.out.println("A:"+add3.getAddTogether(11,11)+"---B:"+add4.getAddTogether(11,11));
    }
}
