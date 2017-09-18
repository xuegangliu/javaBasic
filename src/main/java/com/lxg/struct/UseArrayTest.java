package com.lxg.struct;

public class UseArrayTest {
    private int[] array;
    private int number = 0;
    public UseArrayTest(int max){
        array = new int[max];
    }
    public void insert(int value){
        array[number] = value;
        number++;
    }
//    public int find(int value){
//        for (int i= 0; i < number; i++) {
//            if(array[i]==value)
//                return i;
//        }
//        return number;
//    }

    /**
     * 二分查找
     * @param value
     * @return
     */
    public int find(int value){
        int start = 0;
        int end = number-1;
        while(end>=start){
            int index =(end + start)/2;
            if(array[index]==value){
                return index;
            }else if(array[index] >value){
                end = index-1;
            }else {
                start = index+1;
            }
        }
        return number;
    }

    public boolean delete(int value){
        int index = find(value);
        if(index != number){
            for (int i = index; i < number-1; i++) {
                array[i] = array[i+1];
            }
            number--;
            return true;
        }
        return false;
    }

    public void display(){
        for (int i = 0; i < number; i++) {
            System.out.printf(array[i]+" ");
        }
    }
    public static void main(String[] args) {
        UseArrayTest ua  = new UseArrayTest(5);
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
}
