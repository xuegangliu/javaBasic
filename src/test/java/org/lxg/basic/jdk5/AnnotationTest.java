package org.lxg.basic.jdk5;


import org.lxg.basic.jdk5.annotation.MethodInfo;
import org.lxg.basic.jdk5.annotation.TargetAnnoTest;

/**
 * @author: Max
 * @date: 2018/4/6 12:53
 * @DES: com.lxg
 */
public class AnnotationTest {
    public static void main(String[]args) {
        saying();
    }

    @MethodInfo( date = "20180504")
    public static void saying() {
    }

    // 此时的Color为默认的RED
    @TargetAnnoTest(name="defaultfontcolor")
    public static void sayHelloWithDefaultFontColor() {
    }

    // 将Color改为BLUE
    @TargetAnnoTest(name="notdefault", Color= TargetAnnoTest.Color.BLUE)
    public static void sayHelloWithRedFontColor() {
    }
}
