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

        SinglyLinkedList myList = new SinglyLinkedList();
        myList.addAtHead(5);
        myList.addAtIndex(1, 2);
        System.out.println(myList.get(1));
        myList.addAtHead(6);
        myList.addAtTail(2);
        System.out.println(myList.get(3));
        myList.addAtTail(1);
        System.out.println(myList.get(5));
        myList.addAtHead(2);
        System.out.println(myList.get(2));
        myList.addAtHead(6);
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
}
