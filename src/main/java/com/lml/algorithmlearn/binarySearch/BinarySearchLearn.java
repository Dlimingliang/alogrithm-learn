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

        //时间复杂度O(logn)
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

        //官方答案
//        int n = nums.length;
//        if (n == 0) {
//            return -1;
//        }
//        if (n == 1) {
//            return nums[0] == target ? 0 : -1;
//        }
//
//        int left = 0, right = nums.length - 1;
//        while (left <= right) {
//            int mid = (right + left) / 2 ;
//            int num = nums[mid];
//            if (num == target) {
//                return mid;
//            }
//
//            if (nums[0] < num) {
//                //在左边的分支上
//                if (nums[0] <= target && target < nums[mid]) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            } else {
//                //在右边的分支上
//                if (nums[mid] < target && target <= nums[nums.length - 1]) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//        }
//        return -1;
    }

    public int firstBadVersion(int n) {

        int left = 1, right = n;
        while (left < right) {

            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        if (n >= 1) {
            return true;
        }
        return false;
    }

    public int findPeakElement(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[0];
        }

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid] + 1) {
                return nums[mid + 1];
            }

            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];

//        //官方
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//
//            int mid = left + (right - left) / 2;
//            if (nums[mid] < nums[right]) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn().findMin(new int[]{11,13,15,17}));
    }
}
