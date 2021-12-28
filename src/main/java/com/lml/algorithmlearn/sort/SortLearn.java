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

    private int[] stackSort(int[] nums) {

        for (int i = nums.length/2 -1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums;
    }

    private static void adjustHeap(int[] nums, int i, int length) {

        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k= 2 * k + 1) {

            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int[] shellSort(int[] nums) {

        for(int gap = nums.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                while(j - gap >= 0 && nums[j] < nums[j - gap]) {
                    swap(nums, j, j-gap);
                    j -= gap;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] array = new int[]{4,6,8,5,9,1,2,3,7};
        array = new SortLearn().shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
