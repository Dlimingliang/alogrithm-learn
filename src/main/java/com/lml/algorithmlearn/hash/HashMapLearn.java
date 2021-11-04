package com.lml.algorithmlearn.hash;

import com.lml.algorithmlearn.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static int firstUniqChar(String s) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], -1);
            } else {
                map.put(chars[i], i);
            }
        }

        int minIndex = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1 && (entry.getValue() < minIndex || minIndex == -1)) {
                minIndex = entry.getValue();
            }
        }
        return minIndex;

        //计数法
        //时间复杂度O(n)
        //空间复杂度O(m 字符的长度)
//        HashMap<Character, Integer> map = new HashMap();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            if (map.get(s.charAt(i)) == 1) {
//                return i;
//            }
//        }
//
//        return -1;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        //时间复杂度O(n + m)
        //空间复杂度O(n)
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;

        //时间复杂度 O(mlogm+nlogn)
        //空间复杂度 O()
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int length1 = nums1.length, length2 = nums2.length;
//        int[] intersection = new int[Math.min(length1, length2)];
//        int index1 = 0, index2 = 0, index = 0;
//        while (index1 < length1 && index2 < length2) {
//            if (nums1[index1] < nums2[index2]) {
//                index1++;
//            } else if (nums1[index1] > nums2[index2]) {
//                index2++;
//            } else {
//                intersection[index] = nums1[index1];
//                index1++;
//                index2++;
//                index++;
//            }
//        }
//        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;

        //时间复杂度O(n)
        //空间复杂度O(min(n,k))
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; ++i) {
//            if (set.contains(nums[i])) return true;
//            set.add(nums[i]);
//            if (set.size() > k) {
//                set.remove(nums[i - k]);
//            }
//        }
//        return false;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        //时间复杂度O(O(nklogk)) n是字符串数量 k是字符串长度 由于需要排序。所以排序的时间复杂度为O(klogk)
        //空间复杂度O(nk)
        int length = strs.length;
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {

            char[] stringArray = strs[i].toCharArray();
            Arrays.sort(stringArray);
            String key = new String(stringArray);
            List<String> stringList = hashMap.getOrDefault(key, new LinkedList());
            stringList.add(strs[i]);
            hashMap.put(key, stringList);
        }

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {

//        System.out.println(isIsomorphic("paper", "title"));
//        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
//        System.out.println(findRestaurant(list1, list2));
//        System.out.println(firstUniqChar("aadadaad"));
//        int[] array = new int[]{1,2,2,1};
//        int[] array2 = new int[]{1,1};
//        System.out.println(intersect(array, array2));

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
