package org.lxg.basic.guice.test.service;

import com.google.inject.ImplementedBy;
import org.lxg.basic.guice.test.service.impl.SampleAdd;

/**
 * Created by Administrator on 2017/7/18.
 */
@ImplementedBy(SampleAdd.class)//指向接口的实现类-默认
//@ProvidedBy()//指定该接口的 Provider 类型
public interface Add {
    int getAddTogether(int a, int b);
}
