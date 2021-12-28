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

    private int[] mergeSort(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] leftNums = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] rightNums = mergeSort(Arrays.copyOfRange(nums, mid , nums.length));
        return merge(leftNums, rightNums);
    }

    private int[] merge(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {

            if (nums1[index1] < nums2[index2]) {
                result[index] = nums1[index1];
                index1++;
            } else {
                result[index] = nums2[index2];
                index2++;
            }
            index++;
        }

        while(index1 == length1 && index2 < length2) {
            result[index] = nums2[index2];
            index2++;
            index++;
        }
        while(index2 == length2 && index1 < length1) {
            result[index] = nums1[index1];
            index1++;
            index++;
        }
        return result;
    }

    private int[] quickSort(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {

        if (start < end) {
            int p = getPosition(nums, start, end);
            quickSort(nums, start, p - 1);
            quickSort(nums, p + 1, end);
        }
    }

    private int getPosition(int[] nums, int start, int end) {

        int temp = nums[end];
        int i = start;
        for (int j = start; j < end; ++j) {
            if (nums[j] < temp) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[end];
        nums[end] = tmp;
        return i;
    }

    public static void main(String[] args) {

        int[] array = new int[]{4,6,8,5,9,1,2,3,7};
        array = new SortLearn().quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
