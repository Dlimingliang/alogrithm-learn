package com.lml.algorithmlearn.Array;

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
        int count = 0, length = nums.length;
        for (int i = 0; i < length; i++) {

            if (String.valueOf(nums[i]).length() % 2 == 0) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

//        int[] array = new int[]{1,1,1,0,1};
//        System.out.println(findMaxConsecutiveOnes(array));
        int[] evenNumberArray = new int[] {12,345,2,6,7896};
        System.out.println(findEvenNumberCount(evenNumberArray));
    }
}
