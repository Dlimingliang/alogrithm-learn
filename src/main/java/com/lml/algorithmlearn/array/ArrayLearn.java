    package com.lml.algorithmlearn.array;

    import java.util.Arrays;

    public class ArrayLearn {

        public static int pivotIndex(int[] nums) {

            //时间复杂度O(n^2)
            //空间复杂度O(1)
    //        int length = nums.length, left, right;
    //        for (int i = 0; i < length; i++) {
    //
    //            left = 0; right = 0;
    //            for (int j = 0; j < i; j++) {
    //                left += nums[j];
    //            }
    //
    //            for (int j = i + 1; j < length; j++) {
    //                right += nums[j];
    //            }
    //            if (left == right) {
    //                return i;
    //            }
    //        }
    //        return -1;
            //时间复杂度O(n)
            //空间复杂度O(1)
            int length = nums.length, sum = 0;
            int total = Arrays.stream(nums).sum();
            for (int i = 0; i < length; i++) {
                if (total - nums[i] == 2 * sum) {
                    return i;
                }
                sum += nums[i];
            }
            return -1;
        }

        public static int searchInsert(int[] nums, int target) {

            //时间复杂度O(logn)
            //空间复杂度O(1)
    //        int end = nums.length, middle = end / 2, start = 0;
    //        if (nums[0] > target) {
    //            return 0;
    //        }
    //        if (nums[end - 1] < target) {
    //            return end;
    //        }
    //        while (true) {
    //            if (nums[middle] == target) {
    //                return middle;
    //            }
    //            if (nums[middle] < target && nums[middle + 1] > target) {
    //                return middle + 1;
    //            }
    //            if (nums[middle] > target) {
    //                end = middle;
    //                middle -= (middle - start) / 2 > 0 ? (middle - start) / 2 : 1;
    //            } else {
    //                start = middle;
    //                middle +=  (end - middle) / 2 > 0 ? (end - middle) / 2 : 1;
    //            }
    //        }

            int length = nums.length;
            int left = 0, right = length -1, result= length;
            while (left <= right) {
                int mid = ((right -left) >> 1) + left;
                if (target <= nums[mid]) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return result;
        }

        public void reverseString(char[] s) {

            //n为数组长度
            //时间复杂度O(logn)
            //空间复杂度O(1)
            int left = 0, right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }

        public static int arrayPairSum(int[] nums) {

            //时间复杂度O(nlogn)
            //空间复杂度O(logn)
            Arrays.sort(nums);
            int result = 0;
            for (int i = nums.length - 2; i >= 0; i = i - 2) {
                result += nums[i];
            }
            return result;
        }

        public static int[] twoSum(int[] numbers, int target) {

            //时间复杂度O(n)
            //空间复杂度O(1)
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[0];
        }

        public static int findMin(int[] nums) {

    //        //时间复杂度O(n)
    //        //空间复杂度O(1)
    //        int length = nums.length, min = Integer.MAX_VALUE;
    //        for (int i = 0; i < length; i++) {
    //            min = Math.min(min, nums[i]);
    //        }
    //        return min;

            //时间复杂度O(logn)
            //空间复杂度O(1)
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    high = pivot;
                } else {
                    low = pivot + 1;
                }
            }
            return nums[low];

        }

        public static void moveZeroes(int[] nums) {

            //时间复杂度O(n)
            //空间复杂度O(1)
            int slow = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    int tem = nums[slow];
                    nums[slow] = nums[i];
                    nums[i] = tem;
                    slow++;
                }
            }
            System.out.println(nums);
        }

        public static void main(String[] args) {

    //        int[] array = new int[]{2, 1, -1};
    //        System.out.println(pivotIndex(array));
    //        int[] array = new int[] {1,3,5,6};
    //        System.out.println(searchInsert(array, 0));
    //        int[] array = new int[]{-1,0};
    //        System.out.println(twoSum(array, -1));
//            System.out.println(findMin(new int[]{11,13,15,17}));
            moveZeroes(new int[]{0,1,0,3,12});
        }
    }
