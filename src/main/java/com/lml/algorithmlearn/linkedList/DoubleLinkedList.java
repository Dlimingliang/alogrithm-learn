package com.lml.algorithmlearn.linkedList;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/26 08:19
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class DoubleLinkedList {

    int size;
    DoubleListNode head;

    public DoubleLinkedList() {
        size = 0;
        head = null;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        DoubleListNode currentNode = head;
        while (index > 0) {
            currentNode = currentNode.next;
            index--;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {

        DoubleListNode newNode = new DoubleListNode(val);
        newNode.next = head;
        if (head != null) {
            head.pre = newNode;
        }
        this.head = newNode;
        size++;
    }

    public void addAtTail(int val) {

        if (size == 0) {
            addAtHead(val);
        } else {

            DoubleListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            DoubleListNode newNode = new DoubleListNode(val);
            lastNode.next = newNode;
            newNode.pre = lastNode;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            DoubleListNode currentNode = head;
            while (index > 0) {
                currentNode = currentNode.next;
                index--;
            }
            DoubleListNode newNode = new DoubleListNode(val);
            newNode.pre = currentNode.pre;
            newNode.next = currentNode;
            currentNode.pre.next = newNode;
            currentNode.pre = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index > size -1) {
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            DoubleListNode currentNode = head;
            while (index > 0) {
                currentNode = currentNode.next;
                index--;
            }
            currentNode.pre.next = currentNode.next;
            if (currentNode.next != null) {
                currentNode.next.pre = currentNode.pre;
            }
        }
        size--;
    }

    public static void main(String[] args) {

        DoubleLinkedList myLinkedList = new DoubleLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
    }
}

class DoubleListNode {

    int val;
    DoubleListNode pre;
    DoubleListNode next;

    public DoubleListNode(int val) {
        this.val = val;
    }
}


