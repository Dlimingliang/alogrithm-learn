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

//        //时间复杂度O(n)
//        //空间复杂度O(n)
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                return nums[i];
//            } else {
//                set.add(nums[i]);
//            }
//        }
//        return -1;

        //二分查找 时间复杂度O(nlogn) 空间复杂度O(1)
        int n = nums.length;
        int left = 1, right = n - 1, ans = -1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }

        }
        return ans;

//        //快慢指针 时间复杂度O(n) 空间复杂度O(1)
//        int slow = 0, fast = 0;
//        while (true) {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//            if (slow == fast) {
//                break;
//            }
//        }
//        slow = 0;
//        while (slow != fast) {
//            slow = nums[slow];
//            fast = nums[fast];
//        }
//        return slow;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //时间复杂度O(m+n)
        //空间复杂度O(1)
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] array = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {

            if (nums1[index1] < nums2[index2]) {
                array[index] = nums1[index1];
                index1++;
            } else {
                array[index] = nums2[index2];
                index2++;
            }
            index++;
        }

        while (index1 < length1) {
            array[index] = nums1[index1];
            index1++;
            index++;
        }

        while (index2 < length2) {
            array[index] = nums2[index2];
            index2++;
            index++;
        }

        int n = (length1 + length2) / 2;
        return (length1 + length2) % 2 == 0 ? (double)(array[n -1] + array[n]) / 2 :  array[n];
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn2().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
