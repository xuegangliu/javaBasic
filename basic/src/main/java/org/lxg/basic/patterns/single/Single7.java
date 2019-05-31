package org.lxg.basic.patterns.single;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuegangliu
 * 使用容器实现单例模式
 */
public class Single7 {
    private static Map<String,Object> objMap = new HashMap<String,Object>();
    private Single7() { }
    public static void registerService(String key,Object instance) {
        if(!objMap.containsKey(key)) {
            objMap.put(key,instance);
        }
    }
    public static Object getService(String key) {
        return objMap.get(key);
    }
}