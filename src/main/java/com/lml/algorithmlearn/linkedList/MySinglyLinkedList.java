package com.lml.algorithmlearn.linkedList;

public class MySinglyLinkedList {

    private int size;
    private SinglyListNode head;

    public MySinglyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return  -1;
        }
        SinglyListNode temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        SinglyListNode newHead = new SinglyListNode(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        } else {
            SinglyListNode newHead = new SinglyListNode(val);
            //获取最后的节点。指向新节点
            SinglyListNode temp = head;
            for (int i = 1; i < size; i++) {
                temp = temp.next;
            }
            temp.next = newHead;
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
            SinglyListNode newHead = new SinglyListNode(val);
            SinglyListNode temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newHead.next = temp.next;
            temp.next = newHead;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            SinglyListNode temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public class SinglyListNode {
        int val;
        SinglyListNode next;
        SinglyListNode(int x) { val = x; }
    }
}


