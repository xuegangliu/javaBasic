package com.lxg.problem.bug;

/**************************
 * @description: SampleComparable
 * @author: xuegangliu
 * @date: 2019/4/18 15:06
 * @since: jdk1.8+
 ***************************/
public class SampleComparable {
//    static class Bar implements Comparable<Bar> {
//        public int compareTo(Bar rhs) {
//            return -1;
//        }
//    }
//
//    static class FooBar extends Bar {
//        public int compareTo(FooBar rhs) {  // Noncompliant: Parameter should be of type Bar
//            return 0;
//        }
//    }

    static class Bar implements Comparable<Bar> {
        public int compareTo(Bar rhs) {
            return -1;
        }
    }

    static class FooBar extends Bar {
        public int compareTo(Bar rhs) {
            return 0;
        }
    }
}
