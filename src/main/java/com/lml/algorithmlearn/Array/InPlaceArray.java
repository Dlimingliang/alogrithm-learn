package com.lml.algorithmlearn.Array;

import java.util.Arrays;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/21 08:41
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class InPlaceArray {

    public static int[] replaceElements(int[] arr) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = arr.length, max = -1;

        if (length == 1) {
            arr[0] = max;
        }

        for (int i = length - 1; i >=0 ; i--) {

            int current = arr[i];
            arr[i] = max;
            if (current > max) {
                max = current;
            }

        }

        return arr;
    }

    public static void moveZeroes(int[] nums) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = nums.length, zeroIndex = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                zeroIndex ++;
            }
        }

        if (zeroIndex < length) {
            for (int i = zeroIndex; i < length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void moveZeroesBetter(int[] nums) {

        int length = nums.length, left = 0, right = 0;
        while (right < length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        System.out.println(nums);
    }

    public static int[] sortArrayByParity(int[] nums) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = nums.length, left = 0, right = length - 1;
        while (left < right) {

            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else if (nums[left] % 2 == 0) {
                left++;
            } else if (nums[right] % 2 != 0) {
                right--;
            }
        }
        return nums;
    }

    public static int heightChecker(int[] heights) {

        //时间复杂度 虽然有俩层循环，但是外层循环固定。 所以为O(n)
        //空间复杂度 因为是固定空间、所以为O(1)
        int[] arr = new int[101];
        int length = heights.length, result = 0;
        for (int i = 1; i < heights.length; i++) {
            arr[heights[i]]++;
        }

        for (int i = 1, j = 0; i < length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) {
                    result++;
                }
            }
        }
        //计算正确的数组

        return result;
    }


    public static void main(String[] args) {

//        int[] array = new int[]{17,18,5,4,6,1};
//        replaceElements(array);
//        int[] moveArray = new int[]{0,1,0,3,12};
//        moveZeroesBetter(moveArray);
//        int[] sortArray = new int[]{0};
//        sortArrayByParity(sortArray);
        int[] heightCheckerArray = new int[]{1,1,4,2,1,3};
        System.out.println(heightChecker(heightCheckerArray));;
    }
}
