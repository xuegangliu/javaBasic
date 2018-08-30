package org.lxg.basic.patterns.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuegangliu
 * @date: 8/30/2018 3:18 PM
 * @DES:
 * @version: v1.0
 */
public class IteratorTest {

    @Test
    public void iteratorTest(){
        List<Song> list = new ArrayList<>();
        list.add(new Song("空白格","杨宗纬"));
        list.add(new Song("那时候的我","刘惜君"));
        list.add(new Song("黑泽明","陈奕迅"));
        list.add(new Song("今天只做一件事","陈奕迅"));
        list.add(new Song("童话镇","陈一发儿"));

        MyStoryList songList = new MyStoryList(list);

        Iterator iterator = songList.getIterator();

        while (iterator.hashNext()) {
            System.out.println(iterator.currentItem().toString());
            iterator.next();
        }
    }
}
