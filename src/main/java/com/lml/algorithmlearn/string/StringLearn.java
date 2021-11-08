package com.lml.algorithmlearn.string;

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

    public static void main(String[] args) {

        String[] stringArray = new String[]{"flower","fkow"};
        System.out.println(longestCommonPrefix(stringArray));
    }
}
