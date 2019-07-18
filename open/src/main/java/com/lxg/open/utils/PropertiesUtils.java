package com.lxg.open.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesUtils
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/07/18
 * @since 1.8
 **/
public class PropertiesUtils {

    private static String SYSTEM_PROPERTIES_NAME="system.properties";

    public static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream(new File(PropertiesUtils.class.getClassLoader().getResource(SYSTEM_PROPERTIES_NAME).getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
