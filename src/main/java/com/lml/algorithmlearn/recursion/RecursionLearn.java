package com.lml.algorithmlearn.recursion;

public class RecursionLearn {

    public void reverseString(char[] s) {

        //循环获取
        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = s.length;
        int left = 0, right = length - 1;
        while (left < right) {

            char temp = s[left];
            s[left]= s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }
}
