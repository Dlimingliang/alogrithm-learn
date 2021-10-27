package com.lml.algorithmlearn.linkedList;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/22 09:13
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class SinglyLinkedList {

    public SinglyLinkedList() {
    }

    private int size = 0;
    private SinglyLinkedNode headNode = null;

    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        SinglyLinkedNode node = headNode;
        while (index > 0) {
            node = node.getNext();
            index--;
        }
        return node.getValue();
    }

    public void addAtHead(int val) {

        SinglyLinkedNode newNode = new SinglyLinkedNode(val);
        newNode.setNext(headNode);
        headNode = newNode;
        size++;
    }

    public void addAtTail(int val) {

        if (size == 0) {
            addAtHead(val);
        } else {
            SinglyLinkedNode node = headNode;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            SinglyLinkedNode newNode = new SinglyLinkedNode(val);
            node.setNext(newNode);
            size++;
        }

    }

    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            SinglyLinkedNode node = headNode;
            while (index > 1) {
                node = node.getNext();
                index--;
            }
            SinglyLinkedNode newNode = new SinglyLinkedNode(val);
            newNode.setNext(node.getNext());
            node.setNext(newNode);
            size++;
        }

    }

    public void deleteAtIndex(int index) {

        if (index > size -1) {
            return;
        }

        if (index == 0) {
            this.headNode = headNode.getNext();
            size--;
            return;
        }

        SinglyLinkedNode preNode = null;
        SinglyLinkedNode currentNode = headNode;
        while (index > 0) {
            preNode = currentNode;
            currentNode = currentNode.getNext();
            index--;
        }
        preNode.setNext(currentNode.getNext());
        size--;
    }

    public static void main(String[] args) {

        SinglyLinkedNode node1 = new SinglyLinkedNode(1);
        SinglyLinkedNode node2 = new SinglyLinkedNode(2);
        SinglyLinkedNode node3 = new SinglyLinkedNode(3);
        SinglyLinkedNode node4 = new SinglyLinkedNode(4);
        SinglyLinkedNode node5 = new SinglyLinkedNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        SinglyLinkedNode singlyLinkedNode = node1.rotateRight(node1, 1);
        System.out.println(singlyLinkedNode);
    }
}

class SinglyLinkedNode {

    public SinglyLinkedNode(int value) {
        this.value = value;
    }

    public SinglyLinkedNode(int value, SinglyLinkedNode next) {
        this.value = value;
        this.next = next;
    }

    private int value;
    private SinglyLinkedNode next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyLinkedNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode next) {
        this.next = next;
    }

    public boolean hasCycle(SinglyLinkedNode head) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        SinglyLinkedNode fast = head;
        SinglyLinkedNode slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public SinglyLinkedNode detectCycle(SinglyLinkedNode head) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        //首先计算相遇点
        SinglyLinkedNode meetNode = null;
        SinglyLinkedNode fast = head;
        SinglyLinkedNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meetNode = fast;
                break;
            }
        }
        if (meetNode == null) {
            return meetNode;
        }
        //重置慢节点然后计算入环点
        slow = head;
        while(true) {
            if (slow == meetNode) {
                break;
            } else {
                slow = slow.next;
                meetNode = meetNode.next;
            }
        }
        return meetNode;
    }

    public SinglyLinkedNode getIntersectionNode(SinglyLinkedNode headA, SinglyLinkedNode headB) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if(headA==null||headB==null) return null;
        SinglyLinkedNode pA = headA, pB =headB;
        while (pA!=pB){
            if (pA==null){
                pA=headB;
            }
            else{
                pA=pA.next;
            }
            if (pB==null){
                pB=headA;
            }
            else{
                pB=pB.next;
            }
        }
        return pA;
    }

    public SinglyLinkedNode removeNthFromEnd(SinglyLinkedNode head, int n) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if(head == null || head.next == null || n < 0){
            return null;
        }
        if(n == 0){
            return head;
        }

        SinglyLinkedNode fast = head, slow = head;
        while (n-- > 0) {
            fast = fast.next;
        }

        //尾节点
        if(fast == null){
            slow = slow.next;
            return slow;

        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public SinglyLinkedNode reverseList(SinglyLinkedNode head) {

        //循环链表将其反转
        //时间复杂度O(n)
        //空间复杂度O(1)
        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedNode result = null;
        while (head != null) {

            SinglyLinkedNode currentNode = head;
            head = currentNode.next;
            currentNode.next = result;
            result = currentNode;
        }
        return result;
    }

    public SinglyLinkedNode reverseListOfficial(SinglyLinkedNode head) {
        SinglyLinkedNode prev = null;
        SinglyLinkedNode curr = head;
        while (curr != null) {
            SinglyLinkedNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public SinglyLinkedNode removeElements(SinglyLinkedNode head, int val) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (head == null) {
            return head;
        }

        SinglyLinkedNode result = new SinglyLinkedNode(-1, head);
        SinglyLinkedNode temp = result;
        while (temp.next != null) {

            if (temp.next.value == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return result.next;
    }

    public SinglyLinkedNode oddEvenList(SinglyLinkedNode head) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (head == null) {
            return head;
        }

        SinglyLinkedNode evenHead = head.next;
        SinglyLinkedNode odd = head, even = evenHead;
        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public boolean isPalindrome(SinglyLinkedNode head) {

        SinglyLinkedNode firstHalf = endOfFirstHalf(head);
        SinglyLinkedNode secondHalf = reverseListOfficial(firstHalf.next);

        SinglyLinkedNode p1 = head;
        SinglyLinkedNode p2 = secondHalf;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.value != p2.value) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalf.next = reverseListOfficial(secondHalf);
        return result;
    }

    public boolean isPalindromeBetter(SinglyLinkedNode head) {

        SinglyLinkedNode fast = head, slow = head;
        SinglyLinkedNode reverseNode = null, temp = null;

        while (fast != null && fast.next != null) {

            //翻转前半部分
            temp = slow;
            //快慢指针移动到中间
            slow = slow.next;
            fast = fast.next.next;

            temp.next = reverseNode;
            reverseNode = temp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (reverseNode != null && slow != null) {
            if (reverseNode.value != slow.value) {
                return false;
            }
            reverseNode = reverseNode.next;
            slow = slow.next;
        }
        return true;
    }

    private SinglyLinkedNode endOfFirstHalf(SinglyLinkedNode head) {

        SinglyLinkedNode fast = head;
        SinglyLinkedNode slow = head;

        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public SinglyLinkedNode mergeTwoLists(SinglyLinkedNode l1, SinglyLinkedNode l2) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        SinglyLinkedNode result = new SinglyLinkedNode(0);
        SinglyLinkedNode temp = result;
        while (l1 != null && l2 != null) {

            if (l1.value <= l2.value) {

                temp.next = l1;
                l1 = l1.next;
            } else {

                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        temp.next = l1 == null ? l2 : l1;
        return result.next;
    }

    public SinglyLinkedNode addTwoNumbers(SinglyLinkedNode l1, SinglyLinkedNode l2) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        SinglyLinkedNode result = new SinglyLinkedNode(0);
        SinglyLinkedNode temp = result;
        while(l1!= null || l2 != null) {

            int l1Value = l1 == null ? 0 : l1.value;
            int l2Value = l2 == null ? 0 : l2.value;
            int num = l1Value + l2Value;
            if (temp.next != null) {
                num += temp.next.value;
            }
            if (num >= 10) {

                SinglyLinkedNode newNode = new SinglyLinkedNode(num % 10);
                SinglyLinkedNode nextNode = new SinglyLinkedNode(1);
                newNode.next = nextNode;
                temp.next = newNode;
            } else {
                SinglyLinkedNode newNode = new SinglyLinkedNode(num);
                temp.next = newNode;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    public SinglyLinkedNode rotateRight(SinglyLinkedNode  head, int k) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (head == null || head.next == null) {
            return head;
        }

        //首先计算个数，并且将首尾连接。
        int size = 0;
        SinglyLinkedNode temp = head;
        while(temp != null) {
            size++;
            if (temp.next == null && k % size == 0) {
                return head;
            }
            if (temp.next == null && k % size != 0) {
                temp.next = head;
                break;
            }
            temp = temp.next;
        }

        //移动size - k. 然后解开环.
        int moveNum = size - k % size;
        SinglyLinkedNode result = null;
        SinglyLinkedNode pre;
        temp = head;
        while (moveNum > 0) {
            pre = temp;
            temp = temp.next;
            moveNum--;
            if(moveNum == 0) {
                result = temp;
                pre.next = null;
                break;
            }
        }
        return result;
    }
}
