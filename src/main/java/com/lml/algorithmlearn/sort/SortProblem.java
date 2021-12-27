package com.lml.algorithmlearn.sort;

import java.util.Arrays;

public class SortProblem {

    public void moveZeroes(int[] nums) {

        //冒泡排序思路
        //时间复杂度O(n^2)
        //空间复杂度O(1)
        int length = nums.length;
        for (int i = 0; i < length -1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new SortProblem().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
