package com.lml.algorithmlearn.hash;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {

    private static final int BASE = 769;
    private LinkedList<Pair> [] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Pair>();
        }
    }

    private int hash(int key) {
        return key % BASE;
    }

    public void put(int key, int value) {

        int hashKey = hash(key);
        Iterator<Pair> iterator = data[hashKey].iterator();
        while (iterator.hasNext()) {
            Pair element = iterator.next();
            if (element.key == key) {
                element.value = value;
                return;
            }
        }
        data[hashKey].offerLast(new Pair(key, value));
    }

    public int get(int key) {
        int hashKey = hash(key);
        Iterator<Pair> iterator = data[hashKey].iterator();
        while (iterator.hasNext()) {
            Pair element = iterator.next();
            if (element.key == key) {
                return element.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashKey = hash(key);
        Iterator<Pair> iterator = data[hashKey].iterator();
        while (iterator.hasNext()) {
            Pair element = iterator.next();
            if (element.key == key) {
                data[hashKey].remove(element);
                return;
            }
        }
    }

    class Pair {
        int key;
        int value;

        public Pair() {
        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        TestHashMap testHashMap = new TestHashMap();
        testHashMap.put(1, 1);
        testHashMap.put(2, 2);
        System.out.println(testHashMap.get(1));
        System.out.println(testHashMap.get(3));
        testHashMap.put(2, 1);
        System.out.println(testHashMap.get(2));
        testHashMap.remove(2);
        System.out.println(testHashMap.get(2));
    }
}
