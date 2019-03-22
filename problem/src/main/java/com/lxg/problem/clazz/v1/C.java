package com.lxg.problem.clazz.v1;


/**************************
 * @description: C
 * @author: xuegangliu
 * @date: 2019/3/22 14:06
 ***************************/
public  class C extends B implements A{

    private static String name = "C";

    private String name1="c";

    static {
        System.out.println("C static{}"+_VERSION);
    }

    {
        System.out.println("C {}");
    }

    public C(){
        System.out.println("C()");
    }

    public C(String name1){
        this.name1=name1;
        System.out.println("C(String name1)");
    }

    public static void ok(){
        System.out.println("C static C.ok()");
    }

    @Override
    public void say() {
        System.out.println("c.say()");
    }

    public static void main(String[] args) {
        System.out.println("C main()");
    }
}
