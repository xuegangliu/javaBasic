package org.lxg.basic.jdk5.annotation;

/**
 * @author: Max
 * @date: 2018/4/6 14:48
 * @DES: 作用分类
 * ①编写文档：通过代码里标识的元数据生成文档【生成文档doc文档】
 * ②代码分析：通过代码里标识的元数据对代码进行分析【使用反射】
 * ③编译检查：通过代码里标识的元数据让编译器能够实现基本的编译检查【Override】
 */
public @interface AnnoTest {
    String value();
}
