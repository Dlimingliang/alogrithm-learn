package com.lml.algorithmlearn.recursion;

import java.util.Arrays;

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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DivideAndConquer().sortArrayBottomUp(new int[] {1,4,5,6,7,8,2,3})));
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
