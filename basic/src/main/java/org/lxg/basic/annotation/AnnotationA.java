package org.lxg.basic.annotation;

import lombok.extern.slf4j.Slf4j;
import org.lxg.basic.annotation.filed.BaseFiled;
import org.lxg.basic.annotation.method.BasicMethod;

/**
 * AnnotationA
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/16
 * @since 1.8
 **/
@Slf4j
@BasicInfo
public class AnnotationA {
    @BaseFiled(description = "static name",Old = BaseFiled.Old.YES)
    public final static String name="annotationA";

    @BaseFiled(description = "filed1",Old = BaseFiled.Old.YES)
    private String filed1;

    @BaseFiled(description = "filed2",Old = BaseFiled.Old.NO)
    private String filed2;

    static {
        log.info("AnnotationA static");
    }

    @BasicMethod(date = "20190816")
    public static void method1(){
        log.info("AnnotationA static method1()");
    }

    @BasicMethod(date = "20190816",author = "Tue")
    public void method2(){
        log.info("AnnotationA method2() - filed1={},filed2={},name={}",this.filed1,this.filed2,name);
    }

    public AnnotationA(){
        log.info("AnnotationA()");
    }

    public AnnotationA(String filed1,String filed2){
        this.filed1=filed1;
        this.filed2=filed2;
    }

    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    public String getFiled2() {
        return filed2;
    }

    public void setFiled2(String filed2) {
        this.filed2 = filed2;
    }
}
