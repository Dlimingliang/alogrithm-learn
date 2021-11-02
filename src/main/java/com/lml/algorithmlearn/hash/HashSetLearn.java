package com.lml.algorithmlearn.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetLearn {

    public static boolean containsDuplicate(int[] nums) {

        //时间复杂度 O(n)
        //空间复杂度 O(n)
        HashSet hashSet = new HashSet();
        for (int i : nums) {
            if (!hashSet.add(i)) {
                return true;
            }

        }
        return false;
    }

    public static int singleNumber(int[] nums) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int result = 0;
        for (int x: nums){
            result ^= x;
        }
        return result;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        //时间复杂度O(n)
        //空间复杂度 O(n)
        HashSet<Integer> hashSet1 = new HashSet<>();
        for (int x: nums1) {
            hashSet1.add(x);
        }

        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int x: nums2) {
            hashSet2.add(x);
        }

        HashSet<Integer> hashSet3 = new HashSet<>();
        for(int x : hashSet1) {
            if (hashSet2.contains(x)) {
                hashSet3.add(x);
            }
        }

        int index = 0;
        int[] result = new int[hashSet3.size()];
        Iterator<Integer> iterator = hashSet3.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            result[index] = element;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(HashSetLearn.singleNumber(nums));
    }
}
