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
        SinglyLinkedNode result = node1.oddEvenList(node1);
        System.out.println(result);
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
}
