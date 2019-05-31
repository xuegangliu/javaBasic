package com.lxg.core.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**************************
 *  ClassUtils
 * @author xuegangliu
 *  2019/3/1 10:29
 ***************************/
@Slf4j
public class ClassUtils {

    /**
     * 执行对象中的所有方法
     * @param obj 实例化的对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void excuteObjMethod(Object obj) throws InvocationTargetException, IllegalAccessException {
        log.info("----------------- {} ------------------------",obj.getClass().getName());
        Method[] methods = obj.getClass().getDeclaredMethods();
        for(Method t:methods){
            if(t.getParameterCount()==0) {
                log.info("{}():{}", t.getName(), t.invoke(obj, (Object[]) null));
            }
        }
        log.info("-----------------------------------------------");
    }
}
