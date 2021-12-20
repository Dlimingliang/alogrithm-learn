package com.lml.algorithmlearn.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

    public List<String> generateParenthesisBack(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        inorderTraversalRecursion(result, root);
        return result;
    }

    private void inorderTraversalRecursion(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversalRecursion(result, node.left);
        result.add(node.val);
        inorderTraversalRecursion(result, node.right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(currentList);
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {

//        //固定宽度,执行超时
//        //时间复杂度O(n2)
//        //空间复杂度O(1)
//        int area = Integer.MIN_VALUE;
//        int length = heights.length;
//        for (int i = 0; i < length; i++) {
//            int minHeight = Integer.MAX_VALUE;
//            for (int j = i; j < length; j++) {
//                minHeight = Math.min(minHeight, heights[j]);
//                area = Math.max(area, (j - i + 1) * minHeight);
//            }
//
//        }
//        return area;

//        //固定高度
//        //时间复杂度O(n^2)
//        //空间复杂度O(1)
//        int area = Integer.MIN_VALUE;
//        int length = heights.length;
//        for (int i = 0; i < length; i++) {
//            int height = heights[i];
//            int left = i, right = i;
//            while (left - 1 >= 0 && heights[left - 1] >= height) {
//                left--;
//            }
//            while (right + 1 < length && heights[right + 1] >= height) {
//                right++;
//            }
//            area = Math.max(area, (right - left + 1) * height);
//        }
//        return area;

        //利用堆栈来记录坐标，求取面积
        //时间复杂度O(n)
        //时间复杂度O(n)
        int n = heights.length;
        int []left = new int[n];
        int []right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        for (int i = n -1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new RecursionToLoop().largestRectangleArea(new int[]{2,1,5,6,2,3}));
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
