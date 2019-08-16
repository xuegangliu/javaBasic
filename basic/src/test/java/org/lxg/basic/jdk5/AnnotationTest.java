package org.lxg.basic.jdk5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.lxg.basic.annotation.AnnotationA;
import org.lxg.basic.annotation.AnnotationB;
import org.lxg.basic.annotation.filed.BaseFiled;
import org.lxg.basic.annotation.BasicInfo;
import org.lxg.basic.annotation.method.BasicMethod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Max
 *  2018/4/6 12:53
 *  com.lxg
 */
@Slf4j
public class AnnotationTest {

    @Test
    public void testAnnotationA(){
        Class clsA = AnnotationA.class;
        log.info("clsA class:{}",clsA.getName());

        BasicInfo basicTypeA = (BasicInfo) clsA.getAnnotation(BasicInfo.class);
        log.info("clsA {},{}",basicTypeA.version(),basicTypeA.description());


        Field[] fields1 = clsA.getDeclaredFields();
        log.info("----------- field -------------------");
//        Field[] fields = clsA.getFields();
//        for (Field field : fields) {
//            BaseFiled baseFiled = field.getAnnotation(BaseFiled.class);
//            if (baseFiled != null) {
//                log.info("field:{},{},{}",field.getName(),baseFiled.description(),baseFiled.Old());
//            }
//        }
        for (Field field : fields1) {
            BaseFiled baseFiled = field.getAnnotation(BaseFiled.class);
            if (baseFiled != null) {
                log.info("field:{},{},{}",field.getName(),baseFiled.description(),baseFiled.Old());
            }
        }
        log.info("------------ methods ------------------");
        Method[] methods = clsA.getDeclaredMethods();
        for(Method method:methods){
            BasicMethod methodInfo=method.getAnnotation(BasicMethod.class);
            if(methodInfo!=null){
                log.info("Annotation: method:{},author:{},date:{},version:{}",method.getName(),methodInfo.author(),methodInfo.date(),methodInfo.version());
            }
        }
    }

    @Test
    public void testAnnotationB(){
        Class clsB = AnnotationB.class;
        log.info("clsB class:{}",clsB.getName());

        BasicInfo basicTypeB = (BasicInfo) clsB.getAnnotation(BasicInfo.class);
        log.info("clsB {},{}",basicTypeB.version(),basicTypeB.description());


        Field[] fields1 = clsB.getDeclaredFields();
        log.info("----------- field -------------------");
//        Field[] fields = clsA.getFields();
//        for (Field field : fields) {
//            BaseFiled baseFiled = field.getAnnotation(BaseFiled.class);
//            if (baseFiled != null) {
//                log.info("field:{},{},{}",field.getName(),baseFiled.description(),baseFiled.Old());
//            }
//        }
        for (Field field : fields1) {
            BaseFiled baseFiled = field.getAnnotation(BaseFiled.class);
            if (baseFiled != null) {
                log.info("field:{},{},{}",field.getName(),baseFiled.description(),baseFiled.Old());
            }
        }
        log.info("------------ methods ------------------");
        Method[] methods = clsB.getDeclaredMethods();
        for(Method method:methods){
            BasicMethod methodInfo=method.getAnnotation(BasicMethod.class);
            if(methodInfo!=null){
                log.info("Annotation: method:{},author:{},date:{},version:{}",method.getName(),methodInfo.author(),methodInfo.date(),methodInfo.version());
            }
        }
    }
}
