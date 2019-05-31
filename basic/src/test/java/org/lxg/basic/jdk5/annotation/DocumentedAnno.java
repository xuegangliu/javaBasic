package org.lxg.basic.jdk5.annotation;

import java.lang.annotation.Documented;

/**
 * @author Max
 *  2018/4/6 15:06
 *  com.lxg.jdk5.annotation
 */
// 让它定制文档化功能
// 使用此注解时必须设置RetentionPolicy为RUNTIME
@Documented
public @interface DocumentedAnno {
    // 使用枚举类型
    public enum FontColor {
        BLUE,RED,GREEN
    };
    String name();
    FontColor fontColor() default FontColor.RED;
}
