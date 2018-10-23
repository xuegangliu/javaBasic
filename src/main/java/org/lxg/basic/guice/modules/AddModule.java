package org.lxg.basic.guice.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.lxg.basic.guice.anno.A;
import org.lxg.basic.guice.anno.B;
import org.lxg.basic.guice.test.service.Add;
import org.lxg.basic.guice.test.service.impl.SampleAdd;
import org.lxg.basic.guice.test.service.impl.SomeAdd;

/**
 * Created by Administrator on 2017/7/18.
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
