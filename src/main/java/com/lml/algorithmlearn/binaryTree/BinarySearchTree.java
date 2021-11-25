package com.lml.algorithmlearn.binaryTree;

public class BinarySearchTree {

    long min = Long.MIN_VALUE;
    int count = 0;
    public boolean isValidBST(TreeNode root) {

//        isValidBSTInorder(root);
//        return count == 0;
        return isValidBSTRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void isValidBSTInorder(TreeNode root) {

        if (root == null) {
            return;
        }
        isValidBSTInorder(root.left);
        if (min >= root.val) {
            count++;
        }
        min = root.val;
        isValidBSTInorder(root.right);
    }

    private boolean isValidBSTRecursion(TreeNode root, long lower, long upper) {

        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBSTRecursion(root.left, lower, root.val) && isValidBSTRecursion(root.right, root.val, upper);
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
