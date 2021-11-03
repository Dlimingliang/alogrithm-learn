package com.lml.algorithmlearn.hash;

import java.util.HashMap;
import java.util.Map;

public class HashMapLearn {

    public int[] twoSum(int[] nums, int target) {

//        //时间复杂度O(n^2)
//        //空间复杂度O(1)
//        int[] result = new int[2];
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//        return result;
        //时间复杂度o(n)
        //空间复杂度O(n)
        //第一遍放入值
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static boolean isIsomorphic(String s, String t) {

        //时间复杂度o(n)
        //空间复杂度O(n)
        Map<Character, Character> map = new HashMap();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (int i = 0; i < sChar.length; i++) {
            if((map.containsKey(sChar[i]) && !map.get(sChar[i]).equals(tChar[i])) || (!map.containsKey(sChar[i]) && map.containsValue(tChar[i]))) {
                return false;
            }
            map.put(sChar[i], tChar[i]);
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("paper", "title"));
    }
}
