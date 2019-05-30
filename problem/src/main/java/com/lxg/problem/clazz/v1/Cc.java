package com.lxg.problem.clazz.v1;


/**************************
 * @description: Cc
 * @author: xuegangliu
 * @date: 2019/3/22 14:06
 ***************************/
public  class Cc extends Bb implements Aa {

    private static String name = "Cc";

    private String name1="c";

    static {
        System.out.println("Cc static{}"+VERSION);
    }

    {
        System.out.println("Cc {}");
    }

    public Cc(){
        System.out.println("Cc()");
    }

    public Cc(String name1){
        this.name1=name1;
        System.out.println("Cc(String name1)");
    }

    public static void ok(){
        System.out.println("Cc static Cc.ok()");
    }

    @Override
    public void say() {
        System.out.println("c.say()");
    }

    public static void main(String[] args) {
        System.out.println("Cc main()");
    }
}
