package com.lml.algorithmlearn.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecursionLearn {

    public void reverseString(char[] s) {

        //循环获取
        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = s.length;
        int left = 0, right = length - 1;
        while (left < right) {

            char temp = s[left];
            s[left]= s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }

    public ListNode swapPairs(ListNode head) {

        //递归的方法
        //时间复杂度O(n)
        //空间复杂度O(n)
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;
        return second;

//        //循环的方法
//        //时间复杂度O(n)
//        //空间复杂度O(1)
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        ListNode temp = pre;
//        while (temp.next != null && temp.next.next != null) {
//            ListNode node1 = temp.next;
//            ListNode node2 = temp.next.next;
//            temp.next = node2;
//            node1.next = node2.next;
//            node2.next = node1;
//            temp = node1;
//        }
//        return pre.next;
    }

    public ListNode reverseList(ListNode head) {

        //递归方式
        //时间复杂度O(n)
        //空间复杂度O(n)
//        return reverseListRecursion(head, null);
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;

//        //循环方式
//        ListNode pre = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
    }

    private ListNode reverseListRecursion(ListNode currentNode, ListNode pre) {

        if (currentNode == null) {
            return pre;
        }

        ListNode next = currentNode.next;
        currentNode.next = pre;
        return reverseListRecursion(next, currentNode);
    }

    public TreeNode searchBST(TreeNode root, int val) {

        //递归方式 h为树的高度
        //时间复杂度O(h)
        //空间复杂度O(h)
        TreeNode result;
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val < val) {
            result = searchBST(root.right, val);
        } else {
            result = searchBST(root.left, val);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {

        if (rowIndex == 0) {
            List<Integer> integerList = new LinkedList<>();
            integerList.add(1);
            return integerList;
        }

        if (rowIndex == 1) {
            List<Integer> integerList = new LinkedList<>();
            integerList.add(1);
            integerList.add(1);
            return integerList;
        }

        List<Integer> preRow = getRow(rowIndex - 1);
        List<Integer> result = new ArrayList<>();
        if (rowIndex > 1) {
            for (int i = 0; i <= rowIndex; i++) {
                if (i == 0 || i == rowIndex) {
                    result.add(1);
                } else {
                    result.add(preRow.get(i - 1) + preRow.get(i));
                }
            }
        } else {
            result = preRow;
        }
        return result;
    }

    Map<Integer, Integer> fibCache = new HashMap<>();
    public int fib(int n) {

        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }
        int result;
        if (n < 2) {
            result = n;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        fibCache.put(n, result);
        return result;
    }

    Map<Integer, Integer> climbStairsCache = new HashMap<>();
    public int climbStairs(int n) {

        if (climbStairsCache.containsKey(n)) {
            return climbStairsCache.get(n);
        }

        int result;

        if (n == 0) {
            result = 1;
        } else if (n < 0) {
            result = 0;
        } else {
            result = climbStairs(n - 1) + climbStairs(n - 2);
        }
        climbStairsCache.put(n, result);
        return result;
    }

    public int maxDepth(TreeNode root) {

        //h为树的高度 n为节点数
        //时间复杂度O(n)
        //空间复杂度O(h)
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public double myPow(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        return myPowRecursion(x, n);
    }

    private double myPowRecursion(double x, long n) {

        if (n == 0) {
            return 1;
        }

        double y = myPowRecursion(x, n / 2);
        double result;
        if (n % 2 == 0) {
            result = y * y;
        } else {
            result = y * y * x;
        }
        return result;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode root = new ListNode(0);
        ListNode pre = root;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1 != null || node2 != null) {
            if (node1 == null || (node2 != null && node1.val > node2.val)) {
                pre.next = node2;
                pre = pre.next;
                node2 = node2.next;
                continue;
            }
            if (node2 == null || node1.val <= node2.val) {
                pre.next = node1;
                pre = pre.next;
                node1 = node1.next;
                continue;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {

        ListNode list13 = new ListNode(4);
        ListNode list12 = new ListNode(2, list13);
        ListNode list11 = new ListNode(1, list12);

        ListNode list23 = new ListNode(4);
        ListNode list22 = new ListNode(2, list23);
        ListNode list21 = new ListNode(1, list22);

        System.out.println(new RecursionLearn().mergeTwoLists(list11,list21));
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
