package com.lml.algorithmlearn.recursion;

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
        return reverseListRecursion(head, null);
    }

    private ListNode reverseListRecursion(ListNode currentNode, ListNode pre) {

        if (currentNode == null) {
            return pre;
        }

        ListNode next = currentNode.next;
        currentNode.next = pre;
        return reverseListRecursion(next, currentNode);
    }

    public static void main(String[] args) {

        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode root = new ListNode(1, two);
        ListNode result = new RecursionLearn().reverseList(root);
        System.out.println(result);
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
