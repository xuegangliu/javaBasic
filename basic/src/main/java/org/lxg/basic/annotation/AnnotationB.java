package org.lxg.basic.annotation;

import lombok.extern.slf4j.Slf4j;
import org.lxg.basic.annotation.method.BasicMethod;

/**
 * AnnotationB
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/08/16
 * @since 1.8
 **/
@Slf4j
@BasicInfo(version = "v1.0.1",description = "AnnotationB")
public class AnnotationB extends AnnotationA {

    private int b1;

    public AnnotationB(){
        log.info("AnnotationB()");
    }

    public AnnotationB(int b1){
        this.b1=b1;
    }

    public int getB1() {
        return b1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }

    @BasicMethod(date = "20190816")
    public static void methodBo(){
        log.info("AnnotationB static methodB()");
    }
}
