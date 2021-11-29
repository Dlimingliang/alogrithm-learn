package com.lml.algorithmlearn.binaryTree;

public class BalanceBinarySearchTree {

    boolean result = true;
    public boolean isBalanced(TreeNode root) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        height(root);
        return result;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        //时间复杂度O(n)
        //空间复杂度O(logn)
        return sortedArrayToBSTRecursion(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTRecursion(int[] nums, int left , int right) {

//        if (right - left == 1) {
//            return new TreeNode(nums[left]);
//        }
//        int num = right - left;
//        int mid = num % 2 == 0 ? num/2 - 1 : num / 2;
//        TreeNode node = new TreeNode(nums[left + mid]);
//        if (mid == 0) {
//            node.right = new TreeNode(nums[right - 1]);
//        } else {
//            node.left = this.sortedArrayToBSTRecursion(nums, left, left + mid);
//            node.right = this.sortedArrayToBSTRecursion(nums, left + mid + 1, right);
//        }
//        return node;
        if (left > right) {
            return null;
        }
        int mid = (right + left + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = this.sortedArrayToBSTRecursion(nums, left, mid - 1);
        node.right = this.sortedArrayToBSTRecursion(nums, left + mid + 1, right);
        return node;
    }

    public static void main(String[] args) {

//        int[] array = new int[]{1,3};
        int[] array = new int[]{0,1,2,3,4,5};
        TreeNode treeNode = new BalanceBinarySearchTree().sortedArrayToBST(array);
        System.out.println(treeNode.val);
    }

    public static class TreeNode {
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
