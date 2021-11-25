package com.lml.algorithmlearn.binaryTree;

public class BinarySearchTree {

    long min = Long.MIN_VALUE;
    int count = 0;
    public boolean isValidBST(TreeNode root) {

        isValidBSTRecursion(root);
        return count == 0;
    }

    private void isValidBSTRecursion(TreeNode root) {

        if (root == null) {
            return;
        }
        isValidBSTRecursion(root.left);
        if (min >= root.val) {
            count++;
        }
        min = root.val;
        isValidBSTRecursion(root.right);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(new BinarySearchTree().isValidBST(root));
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
