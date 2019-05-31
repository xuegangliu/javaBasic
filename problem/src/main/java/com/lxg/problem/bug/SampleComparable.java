package com.lxg.problem.bug;

/**************************
 * @description: SampleComparable
 * @author: xuegangliu
 * @date: 2019/4/18 15:06
 * @since: jdk1.8+
 ***************************/
public class SampleComparable {

    static class Bar implements Comparable<Bar> {
        @Override
        public int compareTo(Bar rhs) {
            return -1;
        }
    }

    static class FooBar extends Bar {
        @Override
        public int compareTo(Bar rhs) {
            return 0;
        }
    }
}
