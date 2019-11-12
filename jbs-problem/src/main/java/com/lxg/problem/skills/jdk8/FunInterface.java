package com.lxg.problem.skills.jdk8;

/**
 * 函数式接口
 * @author xuegangliu
 */
@FunctionalInterface
public interface FunInterface {
    /**
     * funAt
     */
    void funAt();

    /**
     * ok
     */
    default void ok(){
        System.out.println("@FunctionalInterface FunInterface default ok()");
    }
}
