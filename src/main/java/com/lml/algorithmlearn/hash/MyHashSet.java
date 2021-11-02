package com.lml.algorithmlearn.hash;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet {

    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    private int hash(int key) {
        return key % BASE;
    }

    public void add(int key) {

        int hashKey = hash(key);
        Iterator<Integer> iterators = data[hashKey].iterator();
        while(iterators.hasNext()) {
            Integer element = iterators.next();
            if (element == key) {
                return;
            }
        }
        data[hashKey].offerLast(key);
    }

    public void remove(int key) {
        int hashKey = hash(key);
        Iterator<Integer> iterators = data[hashKey].iterator();
        while(iterators.hasNext()) {
            Integer element = iterators.next();
            if (element == key) {
                data[hashKey].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {

        int hashKey = hash(key);
        Iterator<Integer> iterators = data[hashKey].iterator();
        while(iterators.hasNext()) {
            Integer element = iterators.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestHashSet testHashSet = new TestHashSet();
        testHashSet.add(0);
        System.out.println(testHashSet.contains(0));
    }
}
