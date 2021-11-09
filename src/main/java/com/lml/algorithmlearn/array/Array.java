package com.lml.algorithmlearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static int maxArea(int[] height) {

        //时间复杂度O(n2)
        //空间复杂度O(1)
        int length = height.length, max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int currentValue = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
                if (currentValue > max) {
                    max = currentValue;
                }
            }
        }
        return max;
    }

    public static int maxAreaBetter(int[] height) {

        int max = 0, left = 0, right = height.length -1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[right] > height[left]) {
                left ++;
            } else {
                right --;
            }
        }
        return max;
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    public static List<List<Integer>> generate(int numRows) {

        //时间复杂度O(n^2)
        //空间复杂度O(1)
        List<List<Integer>> result = new ArrayList();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> current = new ArrayList(i);
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    current.add(1);
                    continue;
                }
                if (j == i - 1) {
                    current.add(1);
                    continue;
                }
                List<Integer> pre = result.get(i - 2);
                current.add(j, pre.get(j) + pre.get(j - 1));
            }
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {

//        int[] array = new int[]{1,1,1,0,1};
//        System.out.println(findMaxConsecutiveOnes(array));
//        int[] evenNumberArray = new int[] {12,345,2,6,7896};
//        System.out.println(findEvenNumberCount(evenNumberArray));
//        int [] squareArray = new int[]{-5,-3,-2,-1};
//        squareAndSortArrayByTwoPoint(squareArray);
//        int [] maxAreaArray = new int[]{1,2,1};
//        System.out.println(maxAreaBetter(maxAreaArray));
//        int[] array = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
//        System.out.println(minSubArrayLen(213, array));
        System.out.println(generate(6));
    }
}
