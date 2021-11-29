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

    public static void main(String[] args) {

        TreeNode left = new TreeNode(9);
        TreeNode rightLeftleft = new TreeNode(13);
        TreeNode rightLeft = new TreeNode(15, rightLeftleft, null);
        TreeNode right = new TreeNode(20, rightLeft, null);
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(new BalanceBinarySearchTree().isBalanced(root));
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
