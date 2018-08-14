package org.lxg.basic.jdk5.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author: Max
 * @date: 2018/4/6 13:00
 * @DES: 用@Target指定ElementType属性
 */

// 用于类，接口，枚举但不能是注解
//    TYPE,
//    // 字段上，包括枚举值
//    FIELD,
//    // 方法，不包括构造方法
//    METHOD,
//    // 方法的参数
//    PARAMETER,
//    // 构造方法
//    CONSTRUCTOR,
//    // 本地变量或catch语句
//    LOCAL_VARIABLE,
//    // 注解类型(无数据)
//    ANNOTATION_TYPE,
//    // Java包
//    PACKAGE

// 限制注解使用范围
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
public @interface TargetAnnoTest {
    // 枚举
    enum Color {
        BLUE,
        RED,
        GREEN
    };
    String name();
    Color Color() default Color.RED;
}
