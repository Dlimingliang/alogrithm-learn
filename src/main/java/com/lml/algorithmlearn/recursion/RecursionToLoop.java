package com.lml.algorithmlearn.recursion;

import java.util.Deque;
import java.util.LinkedList;

public class RecursionToLoop {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //n为节点数, h为树的高度
        //时间复杂度 O(n)
        //空间复杂度 O(h)
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeLoop(TreeNode p, TreeNode q) {

        boolean result = true;
        Deque<TreeNode> pQueen = new LinkedList<>();
        Deque<TreeNode> qQueen = new LinkedList<>();
        pQueen.add(p);
        qQueen.add(q);
        while (!pQueen.isEmpty() && result) {

            TreeNode pNode = pQueen.removeFirst();
            TreeNode qNode = qQueen.removeFirst();
            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                result = false;
                continue;
            }
            pQueen.add(pNode.left);
            pQueen.add(pNode.right);
            qQueen.add(qNode.left);
            qQueen.add(qNode.right);
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
