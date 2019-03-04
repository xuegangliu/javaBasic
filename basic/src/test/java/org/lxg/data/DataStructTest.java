package org.lxg.data;

import org.junit.Test;
import org.lxg.data.array.SelfArray;
import org.lxg.data.array.SelfLinkedList;
import org.lxg.data.queue.ArrayQueue;
import org.lxg.data.queue.BaseQueue;
import org.lxg.data.queue.LinkedListQueue;
import org.lxg.data.queue.LoopQueue;
import org.lxg.data.stack.ArrayStack;
import org.lxg.data.stack.BaseStack;
import org.lxg.data.stack.LinkedListStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class DataStructTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test(){
        System.out.println(0x7fffffff);
        System.out.println(2 >> 32);
    }

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

    @Test
    public void testArrayStack(){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
        }
        logger.info("栈数据:{}",stack.toString());
        stack.pop();
        logger.info("出栈后:{}",stack.toString());
        stack.pop();
        logger.info("出栈后:{}",stack.toString());
        logger.info("栈顶元素:{}",stack.peek());
    }

    @Test
    public void testArrayQueue(){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
        }
        logger.info("出队列前:{}",queue);
        queue.dequeue();
        queue.dequeue();
        logger.info("出队列后:{}",queue);
    }

    @Test
    public void testLoopQueue(){
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(opCount);
        double time1 = queueT(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>(opCount);
        double time2 = queueT(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }

    @Test
    public void testBaseLinkedList(){
        SelfLinkedList<Integer> selfLinkedList = new SelfLinkedList<>();
        logger.info("添加之前:{}", selfLinkedList);
        selfLinkedList.addFirst(1);
        logger.info("添加头1:{}", selfLinkedList);
        selfLinkedList.addFirst(2);
        logger.info("添加头2:{}", selfLinkedList);
        selfLinkedList.addLast(3);
        logger.info("添加尾3:{}", selfLinkedList);
        selfLinkedList.addLast(4);
        logger.info("添加尾4:{}", selfLinkedList);
        selfLinkedList.add(2,789);
        logger.info("位置2添加789:{}", selfLinkedList);
        logger.info(selfLinkedList.contains(4)+"");
        selfLinkedList.remove(2);
        selfLinkedList.removeElement(3);
        selfLinkedList.removeFirst();
        logger.info(selfLinkedList.toString());
    }

    @Test
    public void testLinkedListStackTime(){
        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>(opCount);
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        // 其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
    }

    @Test
    public void testLinkedListQueue(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
        }
        logger.info("出队前:{}",queue);
        queue.dequeue();
        queue.dequeue();
        logger.info("出队后:{}",queue);
    }

    @Test
    public void testLinkedListStack(){
        LinkedListStack<Integer> queue = new LinkedListStack<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.push(i);
        }
        logger.info("出栈前:{}",queue);
        queue.pop();
        logger.info("出栈后:{}",queue);
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

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    public double queueT(BaseQueue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private double testStack(BaseStack<Integer> stack, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}