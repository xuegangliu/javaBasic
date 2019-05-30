package com.lxg.problem.clazz.v1;

/**************************
 * @description: Aa
 * @author: xuegangliu
 * @date: 2019/3/22 14:06
 ***************************/
public interface Aa {

    String VERSION="v1.0.0";

    /**
     * say
     */
    void say();

    /**
     * main
     * @param args
     */
    static void main(String[] args) {
        System.out.println("interface Aa main()");
    }
}
