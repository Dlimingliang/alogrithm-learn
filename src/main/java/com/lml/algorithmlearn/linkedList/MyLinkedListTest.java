package com.lml.algorithmlearn.linkedList;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
    }
}
