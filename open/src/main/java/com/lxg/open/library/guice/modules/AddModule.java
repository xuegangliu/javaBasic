package com.lxg.open.library.guice.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.lxg.open.library.guice.anno.A;
import com.lxg.open.library.guice.anno.B;
import com.lxg.open.library.guice.test.service.Add;
import com.lxg.open.library.guice.test.service.impl.SampleAdd;
import com.lxg.open.library.guice.test.service.impl.SomeAdd;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 * 用于使用 Guice API 在一个应用程序中创建 Bindings
 * 维护一组 Bindings
 */
public class AddModule implements Module {
    @Override
    public void configure(Binder binder) {
        //将 SimpleAdd 实现类绑定到 Add 接口上
//        binder.bind(Add.class).to(SampleAdd.class);// 接口和其相应的实现类的映射关系
//        binder.bind(Add.class).to(SomeAdd.class);//同一个接口俩个实现类会报错

        // 同一个接口多个实现类
        binder.bind(Add.class).annotatedWith(A.class).to(SampleAdd.class);
        binder.bind(Add.class).annotatedWith(B.class).to(SomeAdd.class);
    }
}
