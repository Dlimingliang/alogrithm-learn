package com.lml.algorithmlearn.binarySearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BinarySearchLearn2 {

    public double myPow(double x, int n) {

//        if (n < 0) {
//            x = 1 / x;
//            n = Math.abs(n);
//        }
//        return myPowRecursion(x, n);
        long ln = n;
        return n > 0 ? quickMul(x, ln) : 1 / quickMul(x, -ln);
    }

    private double myPowRecursion(double x, long n) {

        if (n == 0) {
            return 1;
        }

        double y = myPowRecursion(x, n / 2);
        double result;
        if (n % 2 == 0) {
            result = y * y;
        } else {
            result = y * y * x;
        }
        return result;
    }

    private double quickMul(double x, long n) {

        double ans = 1;
        double x_contribute = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            n /= 2;
        }
        return ans;
    }

    public boolean isPerfectSquare(int num) {

        long left = 1, right = num;
        while (left <= right) {

            long mid = left + (right - left) / 2;
            long midNum = mid * mid;
            if (midNum == num) {
                return true;
            } else if (midNum < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            char midChar = letters[mid];
            if (midChar <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
//        return left == letters.length ? letters[0] : letters[left];
        return letters[left % letters.length];
    }

    public int findMin(int[] nums) {

        int left = 0, right = nums.length;
        while (left < right) {

            int mid = left + (right -  left) / 2;
            int midNum = nums[mid];
            if (midNum > nums[nums.length - 1]) {

                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMinTwo(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {

            int mid = left + (right -  left) / 2;
            int midNum = nums[mid];
            if (midNum > nums[right]) {

                left = mid + 1;
            } else if (midNum < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int findDuplicate(int[] nums) {

//        //排序再查找
//        //时间复杂度O(nlogn)
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == nums[i + 1]) {
//                return nums[i];
//            }
//        }
//        return -1;

        //时间复杂度O(n)
        //空间复杂度O(n)
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn2().findDuplicate(new int[]{3,1,3,4,2}));
    }
}