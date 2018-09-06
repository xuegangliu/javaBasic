package org.lxg.basic.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.lxg.basic.guice.modules.AddModule;
import org.lxg.basic.guice.test.service.Add;

/**
 * Created by Administrator on 2017/7/18.
 */
public class ModuleTest {

//    public Add add;
//
//    @Inject//将实例注入到客户端
//    public Test(Add add){
//        this.add = add;
//    }
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AddModule());//它只关心如何创建 （Creating）和维护 (Maintaining) 对象（生命周期）
        //将会创建并返回一个 SimpleAdd 类型的实例-->实际上是通过 AddModule.configure()
//        Add add = injector.getInstance(Add.class);

        // 一个接口多个实现类
//        @A Add add1 = injector.getInstance(Add.class);
//        System.out.println("A:Sample="+add1.getAddTogether(11,10));
//        @B Add add2 = injector.getInstance(Add.class);
//        System.out.println("B:Some="+add2.getAddTogether(11,10));

        // Named注释
        Add add3 = (Add)injector.getInstance(Add.class);
        Add add4 = injector.getInstance(Add.class);
        System.out.println("A:"+add3.getAddTogether(11,11)+"---B:"+add4.getAddTogether(11,11));
    }
}
