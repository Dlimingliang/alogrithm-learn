package com.lml.algorithmlearn.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Array {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,3,0,4,5,0};
//        int result = findMaxConsecutiveOnes(nums);
//        System.out.println(result);
//        sortedSquares(nums);
//        duplicateZeros(nums);
//        sortArrayByParity(new int[]{3,1,2,4});
//        System.out.println(thirdMax(new int[]{3, 2, 1, 2, 2}));
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        //时间复杂度O(nlogn) 空间复杂度O(logn)
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        int[] arr = new int[n + 1];
        arr[0] = 1;
        return arr;
    }

    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int max = -1, second = -1, index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] < max && nums[i] > second) {
                second = nums[i];
            }
        }
        if (max >= 2 * second) {
            return index;
        }
        return -1;
    }

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int v : nums) {
            total += v;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new LinkedList<>();
        int length = nums.length;
        int v;
        for (int i = 0; i < length; i++) {
            v = (nums[i] - 1) % length;
            nums[v] += length;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static int thirdMax(int[] nums) {

       long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
       for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                c = b;
                b = a;
                a = nums[i];
            } else if(a > nums[i] && nums[i] > b) {
                c = b;
                b = nums[i];
            } else if (b > nums[i] && nums[i] > c) {
                c = nums[i];
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    public int heightChecker(int[] heights) {

        int[] arr = new int[101];
        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }
        int result = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length;) {
            if (nums[i] % 2 != 0) {
                if (nums[length - 1] % 2 == 0) {
                    int temp = nums[length - 1];
                    nums[length - 1] = nums[i];
                    nums[i] = temp;
                }
                length--;
            } else {
                i++;
            }
        }
        return nums;
    }

    public int[] replaceElements(int[] arr) {
        int max = -1, length = arr.length;
        int current;
        for (int i = length - 1; i >= 0; i--) {
            current = arr[i];
            arr[i] = max;
            if (current > max) {
                max = current;
            }
        }
        return arr;
    }

    public boolean validMountainArray(int[] arr) {

        int i = 0, length = arr.length;
        while (i + 1 < length && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == length - 1) {
            return false;
        }
        while (i + 1 < length && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == length - 1;
    }

    public boolean checkIfExist(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2) && i != map.get(arr[i] * 2)) {
                return true;
            }
            if (arr[i] % 2 == 0 && map.containsKey(arr[i] / 2) && i != map.get(arr[i] / 2 )) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int slow = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    public int removeElement(int[] nums, int val) {

        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return right;
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
