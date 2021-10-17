package com.lml.algorithmlearn.Array;

import java.util.Arrays;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/15 14:47
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class Array {

    public static int findMaxConsecutiveOnes(int[] nums) {

        //时间复杂度 O(n)
        //空间复杂度 O(1)
        int maxConsecutive = 0, currentConsecutive=0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {

            if (nums[i] == 1) {
                currentConsecutive++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
                currentConsecutive = 0;
            }
        }
        maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        return maxConsecutive;
    }

    public static int findEvenNumberCount(int[] nums) {

        //时间复杂度 O(n)
        //空间复杂度 O(1)
        int count = 0;
        for (int i : nums) {

            if (String.valueOf(i).length() % 2 == 0) {
                count ++;
            }
        }
        return count;
    }

    public static int[] squareAndSortArray(int[] nums) {

        //时间复杂度 O(n log n)
        //空间复杂度 O(n)
        int [] ans = new int[nums.length];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    public static int[] squareAndSortArrayByTwoPoint(int[] nums) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = nums.length;
        int negative = -1;
        for (int i = 0; i < length; i++) {

            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int [] ans = new int[length];
        int index = 0, i = negative, j = negative + 1;

        while (i >= 0 || j < length) {

            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                j++;
            } else if(j == length) {

                ans[index] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {

                ans[index] = nums[i] * nums[i];
                i--;
            } else {
                ans[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }
        return ans;
    }

    public static int[] squareAndSortArrayByTwoPointBetter(int[] nums) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = nums.length;
        int [] ans = new int[length];
        int i = 0, j = length -1, index = length -1;
        while (i <= j) {

            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                i++;
            } else {
                ans[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }
        return ans;
    }

    public static void main(String[] args) {

//        int[] array = new int[]{1,1,1,0,1};
//        System.out.println(findMaxConsecutiveOnes(array));
//        int[] evenNumberArray = new int[] {12,345,2,6,7896};
//        System.out.println(findEvenNumberCount(evenNumberArray));
        int [] squareArray = new int[]{-5,-3,-2,-1};
        squareAndSortArrayByTwoPoint(squareArray);
    }
}
