package org.lxg.get;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class HashFunctionTest {

    @Test
    public void test1(){
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println();

        HashFunction student = new HashFunction(3, 2, "Bobo", "Liu");
        System.out.println(student.hashCode());

        HashSet<HashFunction> set = new HashSet<>();
        set.add(student);

        System.out.printf(String.valueOf(set.hashCode()));
        HashMap<HashFunction, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        System.out.println(scores.hashCode());

        HashFunction student2 = new HashFunction(3, 2, "Bobo", "Liu");
        System.out.println(student2.hashCode());
    }
}
