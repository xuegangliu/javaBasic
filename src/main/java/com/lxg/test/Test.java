package com.lxg.test;

public class Test {
    public static void main(String[] args) {
//        int[] a={1,5,6,5,55,9,4,5,6,66};
//        int b[]={1,2,3,4,5};
//        System.out.println(a.length);
//        System.out.println(b.length);
//        System.out.println(b[0]);
//        System.out.println(b[1]);
        Test t = new Test();
        t.test1();
    }

    public void test1(){
        int a=0,b=0,c=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<5;j++){
                if(j==2){
//                    continue;
//                    break;
                    return;
                }
                c=c+1;
            }
            b=b+1;
        }
        a=a+1;
        System.out.println("A="+a+",B="+b+",C="+c);
    }

}
