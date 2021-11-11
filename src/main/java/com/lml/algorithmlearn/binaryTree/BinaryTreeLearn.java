package com.lml.algorithmlearn.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLearn {

    public List<Integer> preorderTraversal(TreeNode root) {

        //n为树的节点数
        //时间复杂度 每个节点访问一次 O(n)
        //空间复杂度 递归的深度为树的深度，即o(n)
        //前序遍历 首先根节点、然后左子树，然后右子树
        List<Integer> result = new LinkedList<>();
        getTreeValue(root, result);
        return  result;
    }

    private void getTreeValue(TreeNode treeNode, List<Integer> result) {

        if (treeNode != null) {
            result.add(treeNode.val);
            if (treeNode.left != null) {
                getTreeValue(treeNode.left, result);
            }
            if (treeNode.right != null) {
                getTreeValue(treeNode.right, result);
            }
        }
    }

    public List<Integer> preorderTraversalLoop(TreeNode root) {

        //n为树的节点数
        //时间复杂度O(n)
        //空间复杂度O(n)
        //前序遍历 首先根节点、然后左子树，然后右子树
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return  result;
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
