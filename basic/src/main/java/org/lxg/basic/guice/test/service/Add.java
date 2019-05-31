package org.lxg.basic.guice.test.service;

import com.google.inject.ImplementedBy;
import org.lxg.basic.guice.test.service.impl.SampleAdd;

//@ProvidedBy()//指定该接口的 Provider 类型
/**
 * @author xuegangliu
 *指向接口的实现类-默认
 */
@ImplementedBy(SampleAdd.class)
public interface Add {

    /**
     * getAddTogether
     * @param a
     * @param b
     * @return
     */
    int getAddTogether(int a, int b);
}
