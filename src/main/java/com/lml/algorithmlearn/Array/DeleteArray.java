package com.lml.algorithmlearn.Array;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/19 10:51
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class DeleteArray {

    public static int removeElement(int[] nums, int val) {

        //时间复杂度O(n)
        //时间复杂度O(1)
        int reslult = 0, length = nums.length;
        for (int i = 0; i < length; i++) {

            if (val != nums[i]) {
                nums[reslult] = nums[i];
                reslult++;
            }
        }
        return reslult;
    }

    public static int removeElementBetter(int[] nums, int val) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int left = 0, right = nums.length;
        while (left < right) {

            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        int[] array = new int[]{0,1,2,2,3,0,4,2};
        removeElementBetter(array, 2);
    }
}
