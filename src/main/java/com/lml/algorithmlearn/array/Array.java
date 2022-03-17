package com.lml.algorithmlearn.array;

public class Array {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1, 1, 1};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                current = 0;
            } else {
                current++;
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }
}
