package com.lxg.problem.skills.jdk8;

/**
 * 函数式接口
 */
@FunctionalInterface
public interface FunInterface {
    void funA();

    default void ok(){
        System.out.println("@FunctionalInterface FunInterface default ok()");
    }
}
