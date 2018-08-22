package org.lxg.basic.util;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

/**
 * @author: xuegangliu
 * @date: 8/22/2018 11:25 AM
 * @DES:
 * @version: v1.0
 */
public class PropertiesTest {

    @Test
    public void loadPropertiesTest() throws IOException {
        Properties prop = new Properties();
        InputStream is =  PropertiesTest.class.getClassLoader().getResourceAsStream("system.properties");
        prop.load(is);
        prop.list(System.out);
        System.out.println("\nappName: " +
                prop.getProperty("appName"));
    }

    @Test
    public void writePropertiesTest() throws IOException {
        Properties p = new Properties();
        p.setProperty("id","dean");
        p.setProperty("password","123456");
        PrintStream fW = new PrintStream("classpath:read.properties");
        p.list(fW);
    }

    @Test
    public void loadXmlTest() throws IOException {
        Properties prop = new Properties();
        InputStream is =  PropertiesTest.class.getClassLoader().getResourceAsStream("t.xml");
        prop.loadFromXML(is);
        prop.list(System.out);
        System.out.println("\nfoo: " +
                prop.getProperty("foo"));
    }
}
