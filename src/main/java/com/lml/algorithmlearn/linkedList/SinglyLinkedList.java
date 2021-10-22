package com.lml.algorithmlearn.linkedList;

import java.util.HashMap;

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

        SinglyLinkedNode node1 = new SinglyLinkedNode(3);
        SinglyLinkedNode node2 = new SinglyLinkedNode(2);
        SinglyLinkedNode node3 = new SinglyLinkedNode(0);
        SinglyLinkedNode node4 = new SinglyLinkedNode(-4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        System.out.println(SinglyLinkedNode.detectCycle(node1));;
    }
}

class SinglyLinkedNode {

    public SinglyLinkedNode(int value) {
        this.value = value;
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

    public static boolean hasCycle(SinglyLinkedNode head) {

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

    public static SinglyLinkedNode detectCycle(SinglyLinkedNode head) {

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
}
