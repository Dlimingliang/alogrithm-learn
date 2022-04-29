package com.lml.algorithmlearn.array;

import java.util.ArrayList;

public class MyArrayList {

    //总体设计目标 变长数组
    // 1. 实例化保存数据
    // 2. 添加元素
    // 3. 删除元素
    // 4. 修改元素
    // 5. 返回size

    private int[] array;
    private int size = 0;

    public MyArrayList() {
        array = new int[]{};
    }

    public MyArrayList(int n) {
        array = new int[n];
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (outOfIndex(index)) {
            return -1;
        }
        return array[index - 1];
    }

    public void add(int num) {
        //如果需要扩容优先进行扩容
        if (size + 1 > array.length) {
            expandArray();
        }
        array[size] = num;
        size++;
    }

    private void expandArray() {
        int[] newArray = new int[size+1];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int update(int index, int num) {
        if (outOfIndex(index)) {
            return -1;
        }
        array[index-1] = num;
        return get(index);
    }

    public int delete(int index) {
        if (outOfIndex(index)) {
            return -1;
        }
        int[] newArray = new int[size-1];
        for (int i = 0; i < index - 1; i++) {
            newArray[i] = array[i];
        }
        for (int i = index; i < size; i++) {
            newArray[i-1] = array[i];
        }
        size--;
        array = newArray;
        return size;
    }

    private boolean outOfIndex(int index) {
        if (index < 0 || index >= size) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();
        System.out.println("myArrayList数组的size为: " + myArrayList.size());
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        System.out.println("myArrayList数组的size为: " + myArrayList.size());
        System.out.println("myArrayList第3个数组的值为: " + myArrayList.get(3));
        myArrayList.update(3, 33);
        System.out.println("myArrayList第3个数组的值为: " + myArrayList.get(3));
        myArrayList.delete(3);
        System.out.println("myArrayList数组的size为: " + myArrayList.size());
        System.out.println("myArrayList第3个数组的值为: " + myArrayList.get(3));

        System.out.println("----------------------------");

        ArrayList arrayList = new ArrayList();
        System.out.println("arrayList数组的size为: " + arrayList.size());
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("arrayList数组的size为: " + arrayList.size());
        System.out.println("arrayList第3个数组的值为: " + arrayList.get(3));
        arrayList.add(3, 33);
        System.out.println("arrayList数组的size为: " + arrayList.size());
        System.out.println("arrayList第3个数组的值为: " + arrayList.get(3));
        arrayList.remove(3);
        System.out.println("arrayList数组的size为: " + arrayList.size());
        System.out.println("arrayList第3个数组的值为: " + arrayList.get(3));
    }
}
