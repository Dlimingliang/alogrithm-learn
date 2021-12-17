package com.lml.algorithmlearn.recursion;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<String> generateParenthesis(int n) {

        //m为组合数
        //时间复杂度O(m)
        //空间复杂度O(m)
        int maxLength = 2 * n;
        List<String> result = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        while (!queue.isEmpty()) {

            String str = queue.poll();
            int leftNum = 0; int rightNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if ("(".equals(str.substring(i,i + 1))) {
                    leftNum++;
                } else {
                    rightNum++;
                }
            }
            if (str.length() == maxLength) {
                result.add(str);
            } else if(leftNum == rightNum){
                String newStr = new StringBuilder(str).append("(").toString();
                queue.offer(newStr);
            } else if (leftNum == n) {
                String newStr = new StringBuilder(str).append(")").toString();
                queue.offer(newStr);
            } else {
                String newStr = new StringBuilder(str).append("(").toString();
                queue.offer(newStr);
                String newStr2 = new StringBuilder(str).append(")").toString();
                queue.offer(newStr2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new RecursionToLoop().generateParenthesis(3);
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
