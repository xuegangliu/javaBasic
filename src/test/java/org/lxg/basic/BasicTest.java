package org.lxg.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class BasicTest {

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
