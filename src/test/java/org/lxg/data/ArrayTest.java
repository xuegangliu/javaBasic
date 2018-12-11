package org.lxg.data;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testBasicArray(){
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i ++)
            arr[i] = i;

        logger.info("--------- 遍历1 ---------------");
        int[] scores = new int[]{100, 99, 66};
        for(int i = 0 ; i < scores.length ; i ++)
            logger.info(scores[i]+"");

        logger.info("--------- 遍历2 ---------------");
        for(int score: scores)
            logger.info(score+"");

        logger.info("--------- scores[0] = 96 修改后 ---------");
        scores[0] = 96;
        for(int i = 0 ; i < scores.length ; i ++)
            logger.info(scores[i]+"");
    }

    @Test
    public void testSelfArray(){
        SelfArray selfArray = new SelfArray();
        logger.info(selfArray.toString());
        selfArray.addFirst(1);
        selfArray.add(1,2);
        logger.info(selfArray.toString());

        selfArray.addLast(3);
        logger.info(selfArray.toString());

        selfArray.add(1,5);
        logger.info(selfArray.toString());

        selfArray.set(0,111);
        logger.info(selfArray.toString());

        logger.info(selfArray.get(2)+"");
        selfArray.addLast(6);
        selfArray.addLast(7);
        selfArray.addLast(8);

        logger.info(selfArray.toString());
        selfArray.remove(4);
        selfArray.find(8);
        selfArray.removeFirst();
        selfArray.removeLast();
        logger.info(selfArray.toString());
        logger.info("selfArray.contains(5):{}",selfArray.contains(5));
        logger.info("selfArray.contains(11):{}",selfArray.contains(11));
    }

    @Test
    public void testStudentArray(){
        SelfArray<Student> arr = new SelfArray<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Charlie", 88));
        logger.info(arr.toString());
    }


    class Student{
        private String name;
        private int score;

        public Student(String studentName, int studentScore){
            name = studentName;
            score = studentScore;
        }

        @Override
        public String toString(){
            return String.format("Student(name: %s, score: %d)", name, score);
        }
    }
}
