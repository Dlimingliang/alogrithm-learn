package com.lml.algorithmlearn.sort;

import java.util.Arrays;

public class SortLearn {

    private int[] bubbleSort(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] array = new int[]{8,9,6,5,4,7,3,1,2};
        array = new SortLearn().bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
