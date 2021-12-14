package com.lml.algorithmlearn.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DivideAndConquer {

    public int[] sortArray(int[] nums) {

        //时间复杂度 因为每次合并的时候需要的时间复杂度为O(n),并且我们需要合并Olog(n)次. 所以归并排序的时间复杂度为O(nlogn)
        //空间复杂度 我们需要额外O(n)的空间来存储中间元素，同时我们的递归深度为Olog(n). 总共我们需要的空间为O(n)
        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return mergeList(left, right);
    }

    private int[] mergeList(int[] list1, int[] list2) {

        int[] result = new int[list1.length + list2.length];
        int index1 = 0, index2 = 0, resultIndex = 0;

        while (index1 < list1.length && index2 < list2.length) {

            if (list1[index1] < list2[index2]) {
                result[resultIndex] = list1[index1];
                index1++;
                resultIndex++;
            } else {
                result[resultIndex] = list2[index2];
                index2++;
                resultIndex++;
            }
        }

        while (index1 < list1.length) {
            result[resultIndex] = list1[index1];
            index1++;
            resultIndex++;
        }
        while (index2 < list2.length) {
            result[resultIndex] = list2[index2];
            index2++;
            resultIndex++;
        }
        return result;
    }

    public int[] sortArrayBottomUp(int[] nums) {

        List<int[]> integers = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(new int[]{nums[i]});
        }
        while (integers.size() > 1) {
            int[] list1 = integers.get(0);
            int[] list2 = integers.get(1);
            integers.remove(0);
            integers.remove(0);
            integers.add(mergeList(list1, list2));
        }
        return integers.get(0);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DivideAndConquer().sortArrayBottomUp(new int[] {1,4,5,6,7,8,2,3})));
    }

}
