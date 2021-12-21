package com.lml.algorithmlearn.binarySearch;

public class BinarySearchLearn {

    public int search(int[] nums, int target) {

        //时间复杂度O(logn)
        //空间复杂度O(1)
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if(num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {

        //时间复杂度O(logx)
        //空间复杂度O(1)
        int left = 0, right = x, result = -1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            long num = (long)mid * (long)mid;
            if (num <= x) {
                result = mid;
                left = mid + 1;
            } else if (num > x) {
                right = mid - 1;
            }
        }
        return result;
    }

    public int searchA(int[] nums, int target) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if(num < target) {
                if (nums[left] > nums[right] && target >= nums[left]) {
                    right = right - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[left] > nums[right] && target <= nums[right]) {
                    left = left + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn().searchA(new int[]{4,5,6,7,8,1,2,3}, 8));
    }
}
