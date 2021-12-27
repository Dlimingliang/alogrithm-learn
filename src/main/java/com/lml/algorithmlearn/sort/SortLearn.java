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

    private int[] selectSort(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int minkey = nums[i];
            for (int j = i; j < length; j++) {
                if (nums[j] < minkey) {
                    int temp = nums[j];
                    nums[j] = minkey;
                    minkey = temp;
                }
            }
            nums[i] = minkey;
        }
        return nums;
    }

    private int[] insertSort(int[] nums) {
        
        int length = nums.length, temp, j, i;
        for (i = 1; i < length; i++) {
            temp = nums[i];
            for (j = i - 1; j >= 0 && temp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] array = new int[]{8,9,6,5,4,7,3,1,2};
        array = new SortLearn().insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}