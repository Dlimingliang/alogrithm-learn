package com.lml.algorithmlearn.recursion;

import java.util.Arrays;

public class DivideAndConquer {

    public int[] sortArray(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return mergeList(left, right);
    }

    private int[] mergeList(int[] list1, int[] list2) {

        int[] result = new int[list1.length + list2.length];
        int index1 = 0, index2 = 0, resultIndex = 0;

        while (index1 < list1.length && index2 < list2.length) {

            if (list1[index1] < list2[index2]) {
                result[resultIndex] = list1[index1];
                index1++;
                resultIndex++;
            } else {
                result[resultIndex] = list2[index2];
                index2++;
                resultIndex++;
            }
        }

        while (index1 < list1.length) {
            result[resultIndex] = list1[index1];
            index1++;
            resultIndex++;
        }
        while (index2 < list2.length) {
            result[resultIndex] = list2[index2];
            index2++;
            resultIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DivideAndConquer().sortArray(new int[] {1,4,5,6,7,8,2,3})));
    }

}
