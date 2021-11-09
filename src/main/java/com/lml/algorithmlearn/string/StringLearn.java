package com.lml.algorithmlearn.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringLearn {

    public static String longestCommonPrefix(String[] strs) {

        //m为字符串长度 n为数组个数

//        //横向查找
//        //时间复杂度O(n*m)
//        //空间复杂度O(1)
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        int count = strs.length;
//        String first = strs[0];
//        for (int i = 1; i < count; i++) {
//
//            int length = Math.min(first.length(), strs[i].length());
//            int index = 0;
//            while (index < length && first.charAt(index) == strs[i].charAt(index)) {
//                index++;
//            }
//            first = first.substring(0, index);
//
//            if (first.length() == 0) {
//                return "";
//            }
//        }
//        return first;

//        //纵向扫描
//        //时间复杂度O(mn)
//        //空间复杂度O(1)
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//        String first = strs[0];
//        int index = 0;
//        for (int i = 0; i < first.length(); i++) {
//            for (int j = 1; j < strs.length; j++) {
//                if (i >= strs[j].length() || first.charAt(i) != strs[j].charAt(i)) {
//                    return first.substring(0, index);
//                }
//            }
//            index++;
//        }
//        return first.substring(0, index);

        //二分查找法
        //时间复杂度O(mnlogm) m最小数组长度, n字符串数量。
        //空间复杂度O(1)
        if (strs == null || strs.length == 0) {
            return "";
        }

        //寻找最小长度
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String reverseWords(String s) {

        //m为空格间隔的字符串个数, n为字符串长度
        //时间复杂度o(n)
        //空间复杂度O(n)
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split(" "));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords2(String s) {

        //m为字符串个数，n为字符串疮长度
        //时间复杂度O(mn)
        //空间复杂度O(m)
        String[] strings = s.split(" ");
        String[] result = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            int right = chars.length -1, left = 0;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            result[i] = Arrays.toString(chars);
        }
        return String.join("", result);
    }

    public static void main(String[] args) {

//        String[] stringArray = new String[]{"flower","fkow"};
//        System.out.println(longestCommonPrefix(stringArray));
//        String s = "  Bob    Loves  Alice   ";
//        System.out.println(reverseWords(s));
        System.out.println(reverseWords2("Let's take LeetCode contest"));
    }
}
