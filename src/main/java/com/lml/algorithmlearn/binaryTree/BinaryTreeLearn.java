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

    public List<Integer> inorderTraversal(TreeNode root) {

        //n为树的节点数
        //时间复杂度O(n) 每个节点访问一次
        //空间复杂度O(n) 递归的深度
        //中序排序 先遍历左子树，然后访问根节点，然后遍历右子树
        List<Integer> result = new LinkedList<>();
        inorderRecursion(root, result);
        return  result;
    }

    private void inorderRecursion(TreeNode node, List<Integer> result) {

        if (node != null) {
            inorderRecursion(node.left, result);
            result.add(node.val);
            inorderRecursion(node.right, result);
        }
    }

    public List<Integer> inorderTraversalLoop(TreeNode root) {

        //n为树的节点数
        //时间复杂度 O(n)
        //空间复杂度 O(n)
        //中序排序 先遍历左子树，然后访问根节点，然后遍历右子树
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        //n为树的节点数
        //时间复杂度O(n)
        //空间复杂度O(n)
        //后序遍历 先遍历左子树，然后遍历右子树，然后访问根元素
        List<Integer> result = new LinkedList<>();
        postorderRecursion(root, result);
        return  result;
    }

    private void postorderRecursion(TreeNode node,  List<Integer> result) {

        if (node != null) {
            postorderRecursion(node.left, result);
            postorderRecursion(node.right, result);
            result.add(node.val);
        }
    }

    public List<Integer> postorderTraversalLoop(TreeNode root) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        TreeNode node = root;
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right != null && pre != node.right) {
                stack.push(node);
                node = node.right;
            } else {
                result.add(node.val);
                pre = node;
                node = null;
            }
        }
        return result;
    }

    public List<Integer> preorderMorris(TreeNode root) {

        //n为节点数
        //时间复杂度O(n)
        //空间复杂度O(1)
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }

        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {

            mostRight = cur.left;
            if (mostRight != null) {

                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    result.add(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                result.add(cur.val);
            }
            cur = cur.right;
        }
        return result;
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
