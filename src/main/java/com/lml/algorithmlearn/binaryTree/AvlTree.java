package com.lml.algorithmlearn.binaryTree;

public class AvlTree {
    private static class TreeNode {
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

    public TreeNode searchBST(TreeNode root, int val) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                //没有子节点
                root = null;
            } else if (root.right != null) {
                //存在右节点，后继节点和当前节点替换，然后删除这个节点
                TreeNode almostLeftNode = getAlmostLeftNode(root.right);
                root.val = almostLeftNode.val;
                root.right = deleteNode(root.right, almostLeftNode.val);
            } else if (root.left != null) {
                //存在左节点，前置节点和当前节点替换，然后删除这个节点
                TreeNode almostRightNode = getAlmostRightNode(root.left);
                root.val = almostRightNode.val;
                root.left =deleteNode(root.left, almostRightNode.val);
            }
        }
        return root;
    }

    private TreeNode getAlmostLeftNode(TreeNode treeNode) {

        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    private TreeNode getAlmostRightNode(TreeNode treeNode) {
        while (treeNode.right != null) {
            treeNode = treeNode.right;
        }
        return treeNode;
    }
}
