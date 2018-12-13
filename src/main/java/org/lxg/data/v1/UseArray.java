package org.lxg.data.v1;

public class UseArray {
    public int[] array;
    public int number = 0;
    public UseArray(int max){
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
}
