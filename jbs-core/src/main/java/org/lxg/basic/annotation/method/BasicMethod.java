package org.lxg.basic.annotation.method;

import java.lang.annotation.*;

/**
 * @author Max
 *  2018/4/6 15:24
 */
@Documented
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
@Inherited
public @interface BasicMethod {
    String author() default "Tony";
    String date();
    int version() default 1;
}
