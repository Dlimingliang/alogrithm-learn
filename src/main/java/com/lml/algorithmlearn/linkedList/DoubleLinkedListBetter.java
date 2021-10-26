package com.lml.algorithmlearn.linkedList;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/26 09:26
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class DoubleLinkedListBetter {

    int size;
    DoubleListNode head;
    DoubleListNode tail;

    public DoubleLinkedListBetter() {
        size = 0;
        head = new DoubleListNode(0);
        tail = new DoubleListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }

        DoubleListNode current = head;
        if (index + 1 < size - index) {

            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {

            current = tail;
            for (int i = 0; i < size - index; i++) {
                current = current.pre;
            }
        }

        return current.val;
    }

    public void addAtHead(int val) {

        DoubleListNode newNode = new DoubleListNode(val);
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {

        DoubleListNode newNode = new DoubleListNode(val);
        newNode.next = tail;
        newNode.pre = tail.pre;
        tail.pre.next = newNode;
        tail.pre = newNode;
        size++;

    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        DoubleListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) succ = succ.pre;
            pred = succ.pre;
        }

        // insertion itself
        ++size;
        DoubleListNode toAdd = new DoubleListNode(val);
        toAdd.pre = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.pre = toAdd;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }
        DoubleListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) succ = succ.pre;
            pred = succ.pre.pre;
        }

        // delete pred.next
        --size;
        pred.next = succ;
        succ.pre = pred;

    }

    public static void main(String[] args) {
        DoubleLinkedListBetter myLinkedList = new DoubleLinkedListBetter();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);

    }
}

