package org.lxg.data.tree;

import org.junit.Test;
import org.lxg.data.set.BSTSet;
import org.lxg.data.set.SetTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TreeTest {

    @Test
    public void testBst(){
        Integer [] arr = {1,2,3,7,9,4,6,3,5};
        BST<Integer> bst1 = new BST<>();
        for(int p:arr)
            bst1.add(p);
        System.out.println(bst1.toString());
        System.out.println("=================================");
        bst1.preOrder();
        System.out.println("=================================");
        bst1.inOrder();
        System.out.println("=================================");
        bst1.postOrder();
    }

    @Test
    public void testPreOrderNR(){
        Integer [] arr = {1,2,3,7,9,4,6,3,5};
        BST<Integer> bst1 = new BST<>();
        for(int p:arr)
            bst1.add(p);
        bst1.preOrderNR();
    }

    @Test
    public void testLevelOrder(){
        Integer [] arr = {1,2,3,7,9,4,6,3,5};
        BST<Integer> bst1 = new BST<>();
        for(int p:arr)
            bst1.add(p);
        bst1.levelOrder();
    }

    @Test
    public void testTT(){
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        // test removeMin
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMin());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");


        // test removeMax
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");
    }

    @Test
    public void testSegmentTree(){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
//        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
//                new Merger<Integer>() {
//                    @Override
//                    public Integer merge(Integer a, Integer b) {
//                        return a + b;
//                    }
//                });

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree.toString());
    }

    @Test
    public void testSegmentTreeQuery(){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);
        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }

    @Test
    public void testBSTFactor(){
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(SetTest.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            BSTFactor<String, Integer> map = new BSTFactor<>();
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
    public void testAVLTree(){
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(SetTest.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            AVLTree<String, Integer> map = new AVLTree<>();
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
    public void testTrieTime(){
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(SetTest.readFile("pride-and-prejudice.txt", words)) {
            long startTime = System.nanoTime();
            BSTSet<String> set = new BSTSet<>();
            for (String word : words)
                set.add(word);
            for (String word : words)
                set.contains(word);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");
            // ---
            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words)
                trie.add(word);
            for (String word : words)
                trie.contains(word);
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }
}
