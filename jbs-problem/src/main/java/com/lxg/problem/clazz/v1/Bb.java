package com.lxg.problem.clazz.v1;

/**************************
 *  Bb
 * @author xuegangliu
 *  2019/3/22 14:06
 ***************************/
public class Bb {
    private static String name="Bb static prop name";
    private String name1;

    static {
        System.out.println("Bb static{}");
    }

    {
        System.out.println("Bb {}");
    }

    public Bb(){
        System.out.println("Bb()");
    }

    public Bb(String name1){
        this.name1=name1;
        System.out.println("Bb(String name1)");
    }

    public void talk(){
        System.out.println("b.talk(){}");
    }

    public static void main(String[] args) {
        System.out.println("Bb main()");
    }
}
