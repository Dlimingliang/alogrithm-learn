package com.lml.algorithmlearn.linkedList;

public class MyDoubleLinkedList {

    private int size;
    private DoubleListNode head;
    private DoubleListNode tail;

    public MyDoubleLinkedList() {
        size = 0;
        head = new DoubleListNode(0);
        tail = new DoubleListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return  -1;
        }

        DoubleListNode temp;
        if (size - index < index + 1) {
            //后遍历
            temp = tail;
            for (int i = 0; i < size-index; i++) {
                temp = temp.pre;
            }
        } else {
            //前遍历
            temp = head;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        DoubleListNode pred = head, succ = head.next;
        DoubleListNode node = new DoubleListNode(val);
        node.pre = pred;
        node.next = succ;
        pred.next = node;
        succ.pre = node;
        size++;
    }

    public void addAtTail(int val) {
        DoubleListNode succ = tail, pred = tail.pre;
        DoubleListNode node = new DoubleListNode(val);
        node.pre = pred;
        node.next = succ;
        pred.next = node;
        succ.pre = node;
        size++;

    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        DoubleListNode node = new DoubleListNode(val);
        DoubleListNode pred, succ;
        if (size - index < index) {
            //后遍历
            succ = tail;
            for (int i = 0; i < size-index; i++) {
                succ = succ.pre;
            }
            pred = succ.pre;
        } else {
            //前遍历
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        }

        node.pre = pred;
        node.next = succ;
        pred.next = node;
        succ.pre = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        DoubleListNode pred, succ;
        if (size - index < index) {
            //后遍历
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) succ = succ.pre;
            pred = succ.pre.pre;
        } else {
            //前遍历
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        }
        --size;
        pred.next = succ;
        succ.pre = pred;
    }

    public class DoubleListNode {
        int val;
        DoubleListNode pre, next;
        DoubleListNode(int x) { val = x; }
    }
}


