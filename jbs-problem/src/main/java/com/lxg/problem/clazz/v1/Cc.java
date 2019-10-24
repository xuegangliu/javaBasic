package com.lxg.problem.clazz.v1;


/**************************
 *  Cc
 * @author xuegangliu
 *  2019/3/22 14:06
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

    @Override
    public void talk(){
        super.talk();
        System.out.println("c.talk(){}");
    }

    public static void main(String[] args) {
        // 1.父类的static{}只加载一次     Bb static{}
        // 2.当前类的static{}只加载一次   Cc static{}v1.0.0
        // 3.当前方法           -----Cc main()
        System.out.println("===============Cc main()");

        // 4.父类 {}块          Bb {}
        // 5.父类 构造器         Bb()
        // 6.当前类 {}块         Cc {}
        // 7.当前类 构造器       Cc()
        Cc c=new Cc();
        System.out.println(c.name1);
        c.say();
        c.talk();
        System.out.println("===============");
        Cc c1=new Cc();
    }
}
