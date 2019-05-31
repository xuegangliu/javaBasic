package org.lxg.basic.patterns.single;

/**
 * @author xuegangliu
 * 懒汉模式双重校验锁
 */
public class Single4 {
    private static volatile Single4 instance = null;
    private Single4() { }
    public static Single4 getInstance() {
        if(instance == null) {
            synchronized(Single4.class) {
                if(instance == null) {
                    instance = new Single4();
                }
            }
        }
        return instance;
    }
}