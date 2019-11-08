package org.lxg.basic.jdk5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * Jdk6Tests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/11/07
 * @since 1.8
 **/
@Slf4j
public class Jdk6Tests {

    @Test
    public void testDeskTop() throws IOException {
        Desktop desktop=Desktop.getDesktop();
//        desktop.open(new File("D:\\workspace\\lxg\\javaBasic\\jbs-core\\src\\test\\java\\org\\lxg\\basic\\jdk5\\Jdk5Tests.java"));
    }
}
