package org.lxg.basic.data;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.lxg.basic.data.array.SelfArray;
import org.lxg.basic.data.array.SelfLinkedList;
import org.lxg.basic.data.queue.ArrayQueue;
import org.lxg.basic.data.queue.BaseQueue;
import org.lxg.basic.data.queue.LinkedListQueue;
import org.lxg.basic.data.queue.LoopQueue;
import org.lxg.basic.data.stack.ArrayStack;
import org.lxg.basic.data.stack.BaseStack;
import org.lxg.basic.data.stack.LinkedListStack;

import java.util.Random;

@Slf4j
public class DataStructTest {

//    Logger log = LoggerFactory.getLogger(this.getClass());

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

        log.info("--------- 遍历1 ---------------");
        int[] scores = new int[]{100, 99, 66};
        for(int i = 0 ; i < scores.length ; i ++)
            log.info(scores[i]+"");

        log.info("--------- 遍历2 ---------------");
        for(int score: scores)
            log.info(score+"");

        log.info("--------- scores[0] = 96 修改后 ---------");
        scores[0] = 96;
        for(int i = 0 ; i < scores.length ; i ++)
            log.info(scores[i]+"");
    }

    @Test
    public void testSelfArray(){
        SelfArray selfArray = new SelfArray();
        log.info(selfArray.toString());
        selfArray.addFirst(1);
        selfArray.add(1,2);
        log.info(selfArray.toString());

        selfArray.addLast(3);
        log.info(selfArray.toString());

        selfArray.add(1,5);
        log.info(selfArray.toString());

        selfArray.set(0,111);
        log.info(selfArray.toString());

        log.info(selfArray.get(2)+"");
        selfArray.addLast(6);
        selfArray.addLast(7);
        selfArray.addLast(8);

        log.info(selfArray.toString());
        selfArray.remove(4);
        selfArray.find(8);
        selfArray.removeFirst();
        selfArray.removeLast();
        log.info(selfArray.toString());
        log.info("selfArray.contains(5):{}",selfArray.contains(5));
        log.info("selfArray.contains(11):{}",selfArray.contains(11));
    }

    @Test
    public void testStudentArray(){
        SelfArray<Student> arr = new SelfArray<>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Charlie", 88));
        log.info(arr.toString());
    }

    @Test
    public void testArrayStack(){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
        }
        log.info("栈数据:{}",stack.toString());
        stack.pop();
        log.info("出栈后:{}",stack.toString());
        stack.pop();
        log.info("出栈后:{}",stack.toString());
        log.info("栈顶元素:{}",stack.peek());
    }

    @Test
    public void testArrayQueue(){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
        }
        log.info("出队列前:{}",queue);
        queue.dequeue();
        queue.dequeue();
        log.info("出队列后:{}",queue);
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
        log.info("添加之前:{}", selfLinkedList);
        selfLinkedList.addFirst(1);
        log.info("添加头1:{}", selfLinkedList);
        selfLinkedList.addFirst(2);
        log.info("添加头2:{}", selfLinkedList);
        selfLinkedList.addLast(3);
        log.info("添加尾3:{}", selfLinkedList);
        selfLinkedList.addLast(4);
        log.info("添加尾4:{}", selfLinkedList);
        selfLinkedList.add(2,789);
        log.info("位置2添加789:{}", selfLinkedList);
        log.info(selfLinkedList.contains(4)+"");
        selfLinkedList.remove(2);
        selfLinkedList.removeElement(3);
        selfLinkedList.removeFirst();
        log.info(selfLinkedList.toString());
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
        log.info("出队前:{}",queue);
        queue.dequeue();
        queue.dequeue();
        log.info("出队后:{}",queue);
    }

    @Test
    public void testLinkedListStack(){
        LinkedListStack<Integer> queue = new LinkedListStack<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.push(i);
        }
        log.info("出栈前:{}",queue);
        queue.pop();
        log.info("出栈后:{}",queue);
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
