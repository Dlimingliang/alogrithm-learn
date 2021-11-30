package com.lml.algorithmlearn.queue;

import java.util.LinkedList;

public class MyCircularQueueByLinkedList {

    private LinkedList<Integer> list;
    private int maxSize;
    public MyCircularQueueByLinkedList(int k) {
        this.list = new LinkedList();
        this.maxSize = k;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        } else {
            this.list.add(value);
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            this.list.removeFirst();
            return true;
        }
    }

    public int Front() {
       if (isEmpty()) {
           return -1;
       } else {
           return this.list.getFirst();
       }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.list.getLast();
        }
    }

    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    public boolean isFull() {
        return this.list.size() == maxSize;
    }

    public static void main(String[] args) {

        MyCircularQueueByLinkedList array = new MyCircularQueueByLinkedList(6);
        array.enQueue(6);
        System.out.println(array.Rear());
        System.out.println(array.Rear());
        array.deQueue();
        array.enQueue(5);
        array.deQueue();

    }
}
