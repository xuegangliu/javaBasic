package org.lxg.basic.jdk5.process;

import org.lxg.basic.jdk5.annotation.MethodInfo;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Max
 *  2018/4/6 15:29
 *  com.lxg.jdk5.process
 */
@SupportedAnnotationTypes( {"MethodInfo"} )
public class MyProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Map<String,String> map = new HashMap<>(  );
        for(TypeElement te:annotations){
            for(Element e: roundEnv.getElementsAnnotatedWith(te)){
                MethodInfo mi=e.getAnnotation( MethodInfo.class );
                map.put(e.getEnclosedElements().toString(),mi.author());
            }
        }
        return false;
    }
}
