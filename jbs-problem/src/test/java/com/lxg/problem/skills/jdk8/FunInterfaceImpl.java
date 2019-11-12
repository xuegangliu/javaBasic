package com.lxg.problem.skills.jdk8;

/**
 * FunInterfaceImpl
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/10/28
 * @since 1.8
 **/
public class FunInterfaceImpl {
    public static void main(String[] args) {
        FunInterface funInterface = ()->{
            System.out.println("ok");
        };
        funInterface.funAt();
    }

}
