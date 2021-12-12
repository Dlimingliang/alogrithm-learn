package com.lml.algorithmlearn.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {

        System.out.println(new RecursionLearn().getRow(3));
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
