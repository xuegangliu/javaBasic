package org.lxg.basic;

import org.junit.Assert;
import org.junit.Test;
import org.lxg.basic.util.FtpUtilTest;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class BasicTest {

    @Test
    public void javaStartTest(){
        // BootstrapClassLoader
        System.out.println(System.getProperty("sun.boot.class.path"));

        // ExtClassLoader
        System.out.println(System.getProperty("java.ext.dirs"));

        // AppClassLoader
        System.out.println(System.getProperty("java.class.path"));

        System.out.println("=======================");
        ClassLoader cl = FtpUtilTest.class.getClassLoader();
        System.out.println("ClassLoader is:"+cl.toString());
        System.out.println("ClassLoader\'s parent is:"+cl.getParent().toString());
        System.out.println("ClassLoader\'s grand father is:"+cl.getParent().getParent().toString());

    }

    @Test
    public void oneTest(){
        Assert.assertEquals("1","1");
    }

    @Test
    public void test(){
        Properties capitals = new Properties();
        Set states;
        String str;

        capitals.put("A", "1");
        capitals.put("B", "2");
        capitals.put("C", "3");
        capitals.put("D", "4");

        // Show all states and capitals in hashtable.
        states = capitals.keySet(); // get set-view of keys
        Iterator itr = states.iterator();
        while(itr.hasNext()) {
            str = (String) itr.next();
            System.out.println("The capital of " +
                    str + " is " + capitals.getProperty(str) + ".");
        }
        System.out.println();

        // look for state not in list -- specify default
        str = capitals.getProperty("A", "Not Found");
        System.out.println("The capital of A is "
                + str + ".");
    }

    /**
     * continue、break、return的区别
     */
    @Test
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
