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

        //外层循环控制合并排序的个数，按照1，2，4，8，16的次数递增
        for (int i = 1; i < nums.length; i = i + i) {
            //内层控制按照外层合并排序的个数来计算需要多少次合并计算
            for (int j = 0; j < nums.length; j = j + 2 * i) {
                //开始合并
                mergeBottomUp(nums, j, j+ i - 1, Math.min(j + 2 * i - 1, nums.length - 1));
            }
        }
        return nums;
    }

    private static void mergeBottomUp(int[] nums, int min, int mid, int max) {

        int i = min;
        int j = mid + 1;
        int[] aux = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
           aux[k] = nums[k];
        }
        for (int k = min; k <= max; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if(j > max) {
                nums[k] = aux[i++];
            } else if(aux[i] < aux[j]) {
                nums[k] =  aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    public boolean isValidBST(TreeNode root) {

        return isValidBSTRecrusion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTRecrusion(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (min >= node.val || node.val >= max) {
            return false;
        }

        boolean leftResult = isValidBSTRecrusion(node.left, min, node.val) ;
        boolean rightResult = isValidBSTRecrusion(node.right, node.val, max);
        return leftResult && rightResult;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        return searchMatrixHelper(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, matrix[0].length - 1, matrix.length - 1, target);
    }

    private boolean searchMatrixHelper(int[][] matrix, int x1, int y1, int x2, int y2, int xMax, int yMax, int target) {

        if (x1 > xMax || y1 > yMax) {
            return false;
        }

        if (x1 == x2 && y1 == y2) {
            return matrix[y1][x1] == target;
        }

        int m1 = (x1 + x2) / 2;
        int m2 = (y1 + y2) / 2;
        if (matrix[m2][m1] == target) {
            return true;
        }

        if (matrix[m2][m1] < target) {
            //抛开左上矩阵
            return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
                    // 左下矩阵
                    searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    // 右下矩阵
                    searchMatrixHelper(matrix, m1 + 1, m2 + 1, x2, y2, x2, y2, target);
        } else {
            //抛开右下矩阵
            // 右上矩阵
            return searchMatrixHelper(matrix, m1 + 1, y1, x2, m2, x2, y2, target) ||
                    // 左下矩阵
                    searchMatrixHelper(matrix, x1, m2 + 1, m1, y2, x2, y2, target) ||
                    // 左上矩阵
                    searchMatrixHelper(matrix, x1, y1, m1, m2, x2, y2, target);
        }
    }


    public boolean searchMatrixBetter(int[][] matrix, int target) {

        //时间复杂度O(m+n)
        // 空间复杂度O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

    private void quickSort(int[] nums) {

        System.out.println(Arrays.toString(quickSortRecursion(nums)));
    }

    private int[] quickSortRecursion(int[] nums) {

        if (nums.length <= 1) {
            return nums;
        }

        int val = nums[0];
        List<Integer> leftList = new LinkedList();
        List<Integer> rightList = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < val) {
                leftList.add(nums[i]);
            } else if (nums[i] > val) {
                rightList.add(nums[i]);
            }
        }
        int[] leftArray = new int[leftList.size()];
        for (int i = 0; i < leftList.size(); i++) {
            leftArray[i] = leftList.get(i);
        }
        int[] rightArray = new int[rightList.size()];
        for (int i = 0; i < rightList.size(); i++) {
            rightArray[i] = rightList.get(i);
        }

        return quickSortConcat(quickSortRecursion(leftArray), val, quickSortRecursion(rightArray));
    }

    private int[] quickSortConcat(int[] nums1, int val, int[] nums2) {

        int[] result = new int[nums1.length + 1 + nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            result[index++] = nums1[i];
        }
        result[index++] = val;
        for (int i = 0; i < nums2.length; i++) {
            result[index++] = nums2[i];
        }
        return result;
    }

    public void quickSortBetter(int [] lst) {
        /* Sorts an array in the ascending order in O(n log n) time */
        int n = lst.length;
        qSort(lst, 0, n - 1);
        System.out.println(Arrays.toString(lst));
    }

    private void qSort(int [] lst, int lo, int hi) {
        if (lo < hi) {
            int p = partition(lst, lo, hi);
            qSort(lst, lo, p - 1);
            qSort(lst, p + 1, hi);
        }
    }

    private int partition(int [] lst, int lo, int hi) {
    /*
      Picks the last element hi as a pivot
      and returns the index of pivot value in the sorted array */
        int pivot = lst[hi];
        int i = lo;
        for (int j = lo; j < hi; ++j) {
            if (lst[j] < pivot) {
                int tmp = lst[i];
                lst[i] = lst[j];
                lst[j] = tmp;
                i++;
            }
        }
        int tmp = lst[i];
        lst[i] = lst[hi];
        lst[hi] = tmp;
        return i;
    }

    public static void main(String[] args) {
        new DivideAndConquer().quickSortBetter(new int[]{1,5,3,2,8,7,6,4});
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
