package org.lxg.data.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class TestBst {

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
}
