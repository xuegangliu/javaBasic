package com.lxg.open.library.collections4;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ApacheCollectionsTests
 * <p>
 * This is description
 * </p>
 *
 * @author xuegangliu 2019/09/04
 * @since 1.8
 **/
public class ApacheCollectionsTests {

    @Test
    public void bagTest (){
        Bag<String> bag = new HashBag<>();

        //add "a" two times to the bag.
        bag.add("a" , 2);

        //add "b" one time to the bag.
        bag.add("b");

        //add "c" one time to the bag.
        bag.add("c");

        //add "d" three times to the bag.
        bag.add("d",3);

        //get the count of "d" present in bag.
        System.out.println("d is present " + bag.getCount("d") + " times.");
        System.out.println("bag: " +bag);

        //get the set of unique values from the bag
        System.out.println("Unique Set: " +bag.uniqueSet());

        //remove 2 occurrences of "d" from the bag
        bag.remove("d",2);
        System.out.println("2 occurences of d removed from bag: " +bag);
        System.out.println("d is present " + bag.getCount("d") + " times.");
        System.out.println("bag: " +bag);
        System.out.println("Unique Set: " +bag.uniqueSet());
    }

    @Test
    public void bidiMapTest(){
        BidiMap<String, String> bidi = new TreeBidiMap<>();

        bidi.put("One", "1");
        bidi.put("Two", "2");
        bidi.put("Three", "3");

        System.out.println(bidi.get("One"));
        System.out.println(bidi.getKey("1"));
        System.out.println("Original Map: " + bidi);

        bidi.removeValue("1");
        System.out.println("Modified Map: " + bidi);
        BidiMap<String, String> inversedMap = bidi.inverseBidiMap();
        System.out.println("Inversed Map: " + inversedMap);
    }

    @Test
    public void mapIteratorTest(){
        IterableMap<String, String> map = new HashedMap<>();

        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");
        map.put("5", "Five");

        MapIterator<String, String> iterator = map.mapIterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = iterator.getValue();

            System.out.println("key: " + key);
            System.out.println("Value: " + value);

            iterator.setValue(value + "_");
        }

        System.out.println(map);
    }

    @Test
    public void orderedMapTest(){
        OrderedMap<String, String> map = new LinkedMap<String, String>();
        map.put("One", "1");
        map.put("Two", "2");
        map.put("Three", "3");

        System.out.println(map.firstKey());
        System.out.println(map.nextKey("One"));
        System.out.println(map.nextKey("Two"));
    }

    @Test
    public void collectionUtilsTest(){
        List<String> list = new LinkedList<String>();

        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, "a");

        System.out.println(list);

        if(list.contains(null)) {
            System.out.println("Null value is present");
        } else {
            System.out.println("Null value is not present");
        }
        System.out.println("-------------------------------------");
        List<String> sortedList1 = Arrays.asList("A","C","E");
        List<String> sortedList2 = Arrays.asList("B","D","F");
        List<String> mergedList = CollectionUtils.collate(sortedList1, sortedList2);
        System.out.println(mergedList);

        System.out.println("-------------------------------------");
        List<String> stringList = Arrays.asList("1","2","3");

        List<Integer> integerList = (List<Integer>) CollectionUtils.collect(stringList,
                new Transformer<String, Integer>() {

                    @Override
                    public Integer transform(String input) {
                        return Integer.parseInt(input);
                    }
                });

        System.out.println(integerList);
    }

    @Test
    public void collectionUtilsTest1(){
//        List<Integer> integerList = new ArrayList<Integer>();
//        integerList.addAll(Arrays.asList(1,2,3,4,5,6,7,8));
//
//        System.out.println("Original List: " + integerList);
//        CollectionUtils.filter(integerList, new Predicate<Integer>() {
//
//            @Override
//            public boolean evaluate(Integer input) {
//                if(input.intValue() % 2 == 0) {
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        System.out.println("Filtered List (Even numbers): " + integerList);

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.addAll(Arrays.asList(1,2,3,4,5,6,7,8));

        System.out.println("Original List: " + integerList);
        CollectionUtils.filterInverse(integerList, new Predicate<Integer>() {

            @Override
            public boolean evaluate(Integer input) {
                if(input.intValue() % 2 == 0) {
                    return true;
                }
                return false;
            }
        });

        System.out.println("Filtered List (Odd numbers): " + integerList);
    }

    @Test
    public void collectionTest(){
        //checking inclusion
        List<String> list1 = Arrays.asList("A","A","A","C","B","B");
        List<String> list2 = Arrays.asList("A","A","B","B");

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Is List 2 contained in List 1: "
                + CollectionUtils.isSubCollection(list2, list1));

        //checking inclusion
//        List<String> list1 = Arrays.asList("A","A","A","C","B","B");
//        List<String> list2 = Arrays.asList("A","A","B","B");
//
//        System.out.println("List 1: " + list1);
//        System.out.println("List 2: " + list2);
//        System.out.println("Commons Objects of List 1 and List 2: "
//                + CollectionUtils.intersection(list1, list2));

        //checking inclusion
//        List<String> list1 = Arrays.asList("A","A","A","C","B","B");
//        List<String> list2 = Arrays.asList("A","A","B","B");
//
//        System.out.println("List 1: " + list1);
//        System.out.println("List 2: " + list2);
//        System.out.println("List 1 - List 2: "
//                + CollectionUtils.subtract(list1, list2));

        //checking inclusion
//        List<String> list1 = Arrays.asList("A","A","A","C","B","B");
//        List<String> list2 = Arrays.asList("A","A","B","B");
//
//        System.out.println("List 1: " + list1);
//        System.out.println("List 2: " + list2);
//        System.out.println("Union of List 1 and List 2: "
//                + CollectionUtils.union(list1, list2));
    }

}
