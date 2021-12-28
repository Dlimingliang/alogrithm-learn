package com.lml.algorithmlearn.sort;

public class SortProblem {

    public void moveZeroes(int[] nums) {

//        //冒泡排序思路
//        //时间复杂度O(n^2)
//        //空间复杂度O(1)
//        int length = nums.length;
//        for (int i = 0; i < length -1; i++) {
//            for (int j = 0; j < length - 1 - i; j++) {
//                if (nums[j] == 0) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }

        //双指针思路，慢指针指向0，快指针指向不是0的值，如果遇见俩个都满足情况。替换值
        //时间复杂度O(n)
        //空间复杂度O(1)
        int slow = -1;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0 && slow == -1) {
                slow = fast;
                continue;
            }
            if (slow != -1 && nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
        }
    }

    public int findKthLargest(int[] nums, int k) {

//        //选择排序方案
//        //时间复杂度O(k * n)
//        //空间复杂度
//        int length = nums.length;
//        for (int i = 0; i < k; i++) {
//            int minKey = nums[i];
//            for (int j = i; j < length; j++) {
//                if (nums[j] > minKey) {
//                    int temp = nums[j];
//                    nums[j] = minKey;
//                    minKey = temp;
//                }
//            }
//            nums[i] = minKey;
//        }
//        return nums[k - 1];

//        //滑动窗口方案
//        //时间复杂度O(n)
//        //空间复杂度O(k)
//        int length = nums.length, index = 0;
//        Queue<Integer> queue = new PriorityQueue<>(k);
//        while (index < length) {
//
//            if (queue.size() < k) {
//                queue.offer(nums[index]);
//                index++;
//                continue;
//            }
//            if (nums[index] > queue.peek()) {
//                queue.poll();
//                queue.offer(nums[index]);
//            }
//            index++;
//        }
//        return queue.poll();

        //堆排序方案
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums[0];
    }

    private void adjustHeap(int[] nums, int i, int length) {

        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {

            if (k + 1 < length && nums[k + 1] > nums[k]) {
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

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        System.out.println(new SortProblem().findKthLargest(nums, 2));
    }
}
