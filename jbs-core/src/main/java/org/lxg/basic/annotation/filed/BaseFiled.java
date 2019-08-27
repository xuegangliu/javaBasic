package org.lxg.basic.annotation.filed;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xuegangliu
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BaseFiled {

    /**
     * Old
     */
    enum Old {
        // YES
        YES,
        // NO
        NO
    }

    String description();
    Old Old() default Old.YES;
}
