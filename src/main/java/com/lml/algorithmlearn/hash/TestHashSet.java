package com.lml.algorithmlearn.hash;

public class TestHashSet {

    public TestHashSet() {

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

    public void add(int key) {
        int hashKey = hash(key);
        Bucket bucket = buckets[hashKey];
        bucket.values[((key - hashKey) / bucketNum)] = key;
    }

    public void remove(int key) {

        if (contains(key)) {
            int hashKey = hash(key);
            Bucket bucket = buckets[hashKey];
            bucket.values[((key - hashKey) / bucketNum)] = -1;
        }
    }

    public boolean contains(int key) {
        int hashKey = hash(key);
        Bucket bucket = buckets[hashKey];
        if (bucket.values[((key - hashKey) / bucketNum)] >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        TestHashSet testHashSet = new TestHashSet();
        testHashSet.add(0);
        System.out.println(testHashSet.contains(0));
    }
}

