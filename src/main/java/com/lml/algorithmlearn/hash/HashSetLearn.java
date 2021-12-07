package com.lml.algorithmlearn.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

//        hash表法
//        //时间复杂度O(n+m)
//        //空间复杂度 O(n+m)
//        HashSet<Integer> hashSet1 = new HashSet<>();
//        for (int x: nums1) {
//            hashSet1.add(x);
//        }
//
//        HashSet<Integer> hashSet2 = new HashSet<>();
//        for (int x: nums2) {
//            hashSet2.add(x);
//        }
//
//        HashSet<Integer> hashSet3 = new HashSet<>();
//        for(int x : hashSet1) {
//            if (hashSet2.contains(x)) {
//                hashSet3.add(x);
//            }
//        }
//
//        int index = 0;
//        int[] result = new int[hashSet3.size()];
//        Iterator<Integer> iterator = hashSet3.iterator();
//        while (iterator.hasNext()) {
//            Integer element = iterator.next();
//            result[index] = element;
//            index++;
//        }
//        return result;

//        双指针+排序
        //时间复杂度O(nlogn+mlogm)
        //空间复杂度O(logm + logn)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0, i = 0, j = 0, length1 = nums1.length, length2 = nums2.length;
        int[] result = new int[length1 + length2];
        while (i < length1 && j < length2) {

            int num1 = nums1[i], num2 = nums2[j];
            if (num1 == num2) {
                if (index == 0 || num1 != result[index - 1]) {
                    result[index++] = num1;
                }
                i++;
                j++;
            } else {
                if (num1 > num2) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static boolean isHappy(int n) {

        //时间复杂度O(logn)
        //空间复杂度O(logn)
        HashSet hashSet = new HashSet();
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getLastNum(n);
        }
        return n == 1;
    }

    public static boolean isHappyBetter(int n) {

        //时间复杂度O(logn)
        //空间复杂度O(1)
        int slow = n;
        int fast = getLastNum(n);
        while (fast != 1 && slow != fast) {
            slow = getLastNum(slow);
            fast = getLastNum(getLastNum(fast));
        }
        return fast == 1;
    }

    private static int getLastNum(int n) {

        int totalNum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalNum += d * d;
        }
        return totalNum;
    }

    public int numJewelsInStones(String jewels, String stones) {

        //n为jewels字符串的长度, m为stones字符串的长度
        //时间复杂度O(m + n)
        //空间复杂度O(n)
        int count = 0;
        Set<String> map = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            map.add(String.valueOf(jewels.charAt(i)));
        }

        for (int i = 0; i < stones.length(); i++) {
            String s = String.valueOf(stones.charAt(i));
            if (map.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                result = Math.max(result, map.size());
                int index = map.get(ch);
                map.clear();
                i = index;
            } else {
                map.put(ch, i);
            }
        }
        return Math.max(result, map.size());
    }

    public static void main(String[] args) {

//        int[] nums = new int[]{4,1,2,1,2};
//        System.out.println(HashSetLearn.singleNumber(nums));
        System.out.println(new HashSetLearn().lengthOfLongestSubstring(""));
    }
}
