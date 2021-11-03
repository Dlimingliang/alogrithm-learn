package com.lml.algorithmlearn.hash;

import com.lml.algorithmlearn.array.Array;

import java.util.ArrayList;
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

    public static String[] findRestaurant(String[] list1, String[] list2) {

        //时间复杂度O(l1 + l2)
        //空间复杂度O(l1 * x)
        HashMap<String, Integer> map = new HashMap();
        int minIndex = Integer.MAX_VALUE, num = 0;
        ArrayList<String> stringArrayList = new ArrayList();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                num = i + map.get(list2[i]);
                if (num < minIndex) {
                    stringArrayList.clear();
                    minIndex = num;
                    stringArrayList.add(list2[i]);
                } else if (num == minIndex) {
                    stringArrayList.add(list2[i]);
                }
            }

        }
        return stringArrayList.toArray(new String[stringArrayList.size()]);
    }



    public static void main(String[] args) {

//        System.out.println(isIsomorphic("paper", "title"));
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(findRestaurant(list1, list2));
    }
}
