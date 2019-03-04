package org.lxg.basic.guice.anno;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/7/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
@Target(ElementType. LOCAL_VARIABLE)
public @interface A {
}
