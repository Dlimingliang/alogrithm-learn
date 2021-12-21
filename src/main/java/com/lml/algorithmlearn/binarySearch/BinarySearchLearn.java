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

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn().search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
