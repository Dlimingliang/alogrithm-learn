package com.lml.algorithmlearn.linkedList;

public class MySinglyLinkedList {

    private int size;
    private SinglyListNode head;

    public MySinglyLinkedList() {
        size = 0;
        head = new SinglyListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return  -1;
        }
        SinglyListNode temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        SinglyListNode newHead = new SinglyListNode(val);
        SinglyListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newHead.next = temp.next;
        temp.next = newHead;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        SinglyListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public class SinglyListNode {
        int val;
        SinglyListNode next;
        SinglyListNode(int x) { val = x; }
    }
}


