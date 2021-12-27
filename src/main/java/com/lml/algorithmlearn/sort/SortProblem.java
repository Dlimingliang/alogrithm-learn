package com.lml.algorithmlearn.sort;

import java.util.Arrays;

public class SortProblem {

    public void moveZeroes(int[] nums) {

//        //冒泡排序思路
//        //时间复杂度O(n^2)
//        //空间复杂度O(1)
//        int length = nums.length;
//        for (int i = 0; i < length -1; i++) {
//            for (int j = 0; j < length - 1 - i; j++) {
//                if (nums[j] == 0) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }

        //双指针思路，慢指针指向0，快指针指向不是0的值，如果遇见俩个都满足情况。替换值
        //时间复杂度O(n)
        //空间复杂度O(1)
        int slow = -1;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0 && slow == -1) {
                slow = fast;
                continue;
            }
            if (slow != -1 && nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new SortProblem().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
