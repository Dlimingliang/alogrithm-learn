package com.lml.algorithmlearn.array;

public class ArrayLearn {

    public static int pivotIndex(int[] nums) {

        //时间复杂度O(n^2)
        //空间复杂度O(1)
        int length = nums.length, left, right;
        for (int i = 0; i < length; i++) {

            left = 0; right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }

            for (int j = i + 1; j < length; j++) {
                right += nums[j];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] array = new int[]{2, 1, -1};
        System.out.println(pivotIndex(array));
    }
}
