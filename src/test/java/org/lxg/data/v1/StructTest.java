package org.lxg.data.v1;

import org.junit.Test;

/**
 * @author: xuegangliu
 * @date: 8/15/2018 3:26 PM
 * @DES:
 * @version: v1.0
 */
public class StructTest {

    @Test
    public void queqeTest(){
        Queqe q = new Queqe(4);
        System.out.println("queqe is empty:"+q.isEmpty());

        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);

        System.out.println(q.size());
        System.out.println("front is "+q.peekFront());

        while(!q.isEmpty())
            System.out.println(q.remove());
    }

    @Test
    public void stackTest(){
        // char array[] 修改为int array[]
//        Stack s = new Stack(5);
//        s.push(1);
//        s.push(3);
//        s.push(5);
//        s.push(5);
//        s.push(5);
//        s.display();//5 5 5 3 1

        char string [] = {55,57,88,99};
        Stack st = new Stack(string.length);
        System.out.println(st.reverse(string));
    }

    @Test
    public void arrayTest(){
        int array[] = new int[10];
        System.out.println(array[2]);// 输出0
        A a[] = new A[12];
        System.out.println(a[1]);// 输出null
    }

    @Test
    public void userArrayTest(){
        UseArray ua  = new UseArray(5);
        ua.insert(1);
        ua.insert(2);
        ua.insert(6);
        ua.insert(7);
        ua.insert(3);

        ua.display();
        if(ua.find(5) != ua.number){
            System.out.println("find,the number index is "+ua.find(5));
        }else{
            System.out.println("not found!");
        }
        if(ua.delete(5)!=true){
            System.out.println("can not delete!");
        }
        ua.display();
    }

    class A{
        {
            System.out.println("{}");
        }
    }
}
