package org.lxg.basic.jdk5.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: Max
 * @date: 2018/4/6 15:04
 * @DES: 注解保持性策略
 * 编译器的处理有三种策略：
 * 将注解保留在编译后的类文件中，并在第一次加载类时读取它；
 * 将注解保留在编译后的类文件中，但是在运行时忽略它；
 * 按照规定使用注解，但是并不将它保留到编译后的类文件中。
 *
 *
 */

// 此类型会被编译器丢弃
//    SOURCE,
//    // 此类型注解会保留在class文件中，但JVM会忽略它
//    CLASS,
//    // 此类型注解会保留在class文件中，JVM会读取它
//    RUNTIME

@Retention(RetentionPolicy.RUNTIME)
public @interface RetentionAnnoTest {
    // 使用枚举类型
    public enum FontColor {
        BLUE,RED,GREEN
    };
    String name();
    FontColor fontColor() default FontColor.RED;
}
