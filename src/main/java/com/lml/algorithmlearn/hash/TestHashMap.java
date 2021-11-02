package com.lml.algorithmlearn.hash;

public class TestHashMap {

    public TestHashMap() {

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
    }

    public static final int bucketNum = 1000;
    public static final Bucket[] buckets = new Bucket[bucketNum];

    private int hash(int key) {
        return key % bucketNum;
    }

    class Bucket {
        int[] values;

        public Bucket() {
            this.values = new int[1001];
            for (int i = 0; i < values.length; i++) {
                values[i] = -1;
            }
        }
    }

    public void put(int key, int value) {
        int hashKey = hash(key);
        Bucket bucket = buckets[hashKey];
        bucket.values[((key - hashKey) / bucketNum)] = value;
    }

    public void remove(int key) {

        int hashKey = hash(key);
        Bucket bucket = buckets[hashKey];
        if (bucket.values[((key - hashKey) / bucketNum)] >= 0) {
            bucket.values[((key - hashKey) / bucketNum)] = -1;
        }
    }

    public int get(int key) {

        int hashKey = hash(key);
        Bucket bucket = buckets[hashKey];
        return bucket.values[((key - hashKey) / bucketNum)];
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

