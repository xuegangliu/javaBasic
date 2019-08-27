package org.lxg.basic.data.map;

import org.junit.Test;
import org.lxg.basic.data.set.SetTest;

import java.util.ArrayList;
import java.util.Arrays;

public class MapTest {

    @Test
    public void testLinkedListMap(){
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(SetTest.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        System.out.println();
    }

    @Test
    public void testBSTMap(){
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(SetTest.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            BstMap<String, Integer> map = new BstMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        System.out.println();
    }

    @Test
    public void testTime(){
        String filename = "pride-and-prejudice.txt";
        BstMap<String, Integer> bstMap = new BstMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("Bst Map: " + time1 + " s");
        System.out.println();
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");
    }

    @Test
    public void testHashTableBase(){
        String s = "abcccdddwt";
        System.out.println(hashTablefirstUniqChar(s,3));
    }

    /**
     * 字符串中(a-z组合)中,字母最多的统计
     * @param s
     * @param count
     * @return
     */
    public boolean hashTablefirstUniqChar(String s,int count) {
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i ++)
            freq[s.charAt(i) - 'a'] ++;
        Arrays.stream(freq).forEach(System.out::print);
        System.out.println();
        System.out.println(s);
        for(int i = 0 ; i < s.length() ; i ++)
            if(freq[s.charAt(i) - 'a'] == count)
                return true;
        return false;
    }

    @Test
    public void testSelfHashTableTime(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(SetTest.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);

            // Test Bst
            long startTime = System.nanoTime();
//            Bst<String, Integer> bst = new Bst<>();
//            for (String word : words) {
//                if (bst.contains(word))
//                    bst.set(word, bst.get(word) + 1);
//                else
//                    bst.add(word, 1);
//            }
//            for(String word: words)
//                bst.contains(word);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
//            System.out.println("Bst: " + time + " s");


            // Test AVL
//            startTime = System.nanoTime();
//            AvlTree<String, Integer> avl = new AvlTree<>();
//            for (String word : words) {
//                if (avl.contains(word))
//                    avl.set(word, avl.get(word) + 1);
//                else
//                    avl.add(word, 1);
//            }
//            for(String word: words)
//                avl.contains(word);
//            endTime = System.nanoTime();
//            time = (endTime - startTime) / 1000000000.0;
//            System.out.println("AVL: " + time + " s");


            // Test RBTree
//            startTime = System.nanoTime();
//            RBTree<String, Integer> rbt = new RBTree<>();
//            for (String word : words) {
//                if (rbt.contains(word))
//                    rbt.set(word, rbt.get(word) + 1);
//                else
//                    rbt.add(word, 1);
//            }
//            for(String word: words)
//                rbt.contains(word);
//            endTime = System.nanoTime();
//            time = (endTime - startTime) / 1000000000.0;
//            System.out.println("RBTree: " + time + " s");


            // Test HashTable
            startTime = System.nanoTime();
            SelfHashTable<String, Integer> ht = new SelfHashTable<>(131071);
            for (String word : words) {
                if (ht.contains(word))
                    ht.set(word, ht.get(word) + 1);
                else
                    ht.add(word, 1);
            }
            for(String word: words)
                ht.contains(word);
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
        }
    }

    private static double testMap(BaseMap<String, Integer> map, String filename){
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(SetTest.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words){
                if(map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
