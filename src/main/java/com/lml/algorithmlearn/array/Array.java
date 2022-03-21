package com.lml.algorithmlearn.array;

public class Array {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,3,0,4,5,0};
//        int result = findMaxConsecutiveOnes(nums);
//        System.out.println(result);
//        sortedSquares(nums);
//        duplicateZeros(nums);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int capacityIndex = nums1.length;
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[capacityIndex-1] = nums1[m-1];
                m--;
            } else {
                nums1[capacityIndex-1] = nums2[n-1];
                n--;
            }
            capacityIndex--;
        }

        while (m > 0) {
            nums1[capacityIndex-1] = nums1[m-1];
            m--;
            capacityIndex--;
        }

        while (n > 0) {
            nums1[capacityIndex-1] = nums2[n-1];
            n--;
            capacityIndex--;
        }
    }

    public static void duplicateZeros(int[] arr) {

        int length = arr.length;
        int moveNum = 0;

        for (int i = 0; i < length - moveNum; i++) {
            if (arr[i] == 0) {
                if (i + moveNum + 1 == length) {
                    arr[length - 1] = 0;
                    length--;
                    break;
                }
                moveNum ++;
            }
        }

        for (int i = length - moveNum - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + moveNum] = arr[i];
                moveNum --;
                arr[i + moveNum] = arr[i];
            } else {
                arr[i + moveNum] = arr[i];
            }
        }
    }

    public static int[] sortedSquares(int[] nums) {

        //时间复杂度 O(n)
        //空间复杂度 O(1)
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int leftSquare, rightSquare, resultIndex = right;
        while (left <= right) {
            leftSquare = nums[left] * nums[left];
            rightSquare = nums[right] * nums[right];
            if (leftSquare < rightSquare) {
                result[resultIndex] = rightSquare;
                right--;
            } else {
                result[resultIndex] = leftSquare;
                left++;
            }
            resultIndex--;
        }
        return result;
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
