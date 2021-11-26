package com.lml.algorithmlearn.binaryTree;

import java.util.ArrayList;
import java.util.List;

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

    class BSTIterator {

        private List<TreeNode> treeNodeList = new ArrayList<>();
        private int current = -1;
        public BSTIterator(TreeNode root) {
            recursion(root, treeNodeList);
        }

        private void recursion(TreeNode treeNode, List treeNodeList) {

            if (treeNode == null) {
                return;
            }
            recursion(treeNode.left, treeNodeList);
            treeNodeList.add(treeNode);
            recursion(treeNode.right, treeNodeList);
        }

        public int next() {
            current++;
            return treeNodeList.get(current).val;
        }

        public boolean hasNext() {
            return current + 1 < treeNodeList.size();
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {

        //n为节点数，h为树的高度
        //recursion
        //时间复杂度 o(n)
        //空间复杂度 递归的深度但是可能为n，所以空间复杂度O(n)
//        if (root == null) {
//            return null;
//        }
//
//        if (root.val == val) {
//            return root;
//        }
//
//       return searchBST(val < root.val ? root.left : root.right, val);
        //Loop
        //时间复杂度O(n)
        //空间复杂度O(1)
        if (root == null) {
            return null;
        }

        while (root != null) {

            if (root.val == val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);
        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(7);
        TreeNode root = new TreeNode(4, left, right);
        System.out.println(new BinarySearchTree().searchBST(root, 5));
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
