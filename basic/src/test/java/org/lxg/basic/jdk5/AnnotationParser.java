package org.lxg.basic.jdk5;

import org.lxg.basic.jdk5.annotation.MethodInfo;

import java.lang.reflect.Method;

/**
 * @author Max
 *  2018/4/6 15:34
 *  com.lxg.jdk5.process
 */
public class AnnotationParser {
    public static void main(String[] args) {
        Class cls = ReadAnnotationInfoTest.class;
        for(Method method:cls.getMethods()){
            MethodInfo methodInfo=method.getAnnotation(MethodInfo.class);
            if(methodInfo!=null){
                System.out.println(method.getName());
                System.out.printf(methodInfo.author());
                System.out.println(methodInfo.date());
                System.out.println(methodInfo.version());
            }
        }
    }
}
