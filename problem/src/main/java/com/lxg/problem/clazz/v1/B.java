package com.lxg.problem.clazz.v1;

/**************************
 * @description: B
 * @author: xuegangliu
 * @date: 2019/3/22 14:06
 ***************************/
public class B {
    private static String name="B static prop name";
    private String name1;

    static {
        System.out.println("B static{}");
    }

    {
        System.out.println("B {}");
    }

    public B(){
        System.out.println("B()");
    }

    public B(String name1){
        this.name1=name1;
        System.out.println("B(String name1)");
    }

    public void talk(){
        System.out.println("b.talk(){}");
    }

    public static void main(String[] args) {
        System.out.println("B main()");
    }
}
