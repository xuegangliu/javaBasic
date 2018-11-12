package org.lxg.basic.sample.reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: xuegangliu
 * @date: 11/12/2018 11:39 AM
 * @DES:
 * @version: v1.0
 */
public class ReflectionTest {

    /**
     * 反射获取类的信息
     * @throws ClassNotFoundException
     */
    @Test
    public void printInfo() throws ClassNotFoundException {
        Class a = Class.forName("org.lxg.basic.sample.reflection.A");
        System.out.println("A isInstance Integer.Type:"+a.isInstance( Integer.TYPE ));
        System.out.println("=====================================");
        Field field[] = a.getFields();
        for(int i=0; i<field.length; i++){
            System.out.println(field[i].toString());
        }

//        Method m[] = a.getMethods();
        Method m[] = a.getDeclaredMethods();
        for(int i=0; i<m.length; i++){
            System.out.println(m[i].toString());
            System.out.println("name:"+m[i].getName());
            System.out.println("class:"+m[i].getDeclaringClass());
            System.out.println("params:"+m[i].getParameterTypes());
            System.out.println("exception:"+m[i].getExceptionTypes());
            System.out.println("return:"+m[i].getReturnType());
        }
    }

    /**
     * 通过反射获取类并执行指定的方法
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void executeTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class a = Class.forName("org.lxg.basic.sample.reflection.A");
//        Class params[] = new Class[1];
//        params[0]=String.class;
        Method talk = a.getMethod( "talk",new Class[]{String.class} ); // 获取指定的方法
        A t = new A();// 对象实例
        Object args[] = new Object[1];
        args[0]="Tony";
        Object m = talk.invoke( t,args );
        System.out.println(m.toString());
    }
}
