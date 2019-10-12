package com.lxg.problem.others;

/**
 * St
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/10/12
 * @since 1.8
 **/
public class St {
    // 私有构造器 必须自己内部去实例化,否则不执行
    private static St b=new St();
    private St(){
        System.out.println(1);
    }

    public static int ok=1;

    public static void ttt(){
        System.out.println(2222222);
    }
}
