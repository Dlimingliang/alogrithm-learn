package com.lml.algorithmlearn.queuestack.queue;

class MyCircularLinkedListQueue {

    private Node head, tail;
    private int count;
    private int capacity;


    public MyCircularLinkedListQueue(int k) {
       this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            Node node = new Node(value);
            if (this.count == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.nextNode = node;
                this.tail = this.tail.nextNode;
            }
            this.count++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            this.head = this.head.nextNode;
            this.count--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (!isEmpty()) {
            return this.head.value;
        }
        return -1;
    }
    
    public int Rear() {
        if (!isEmpty()) {
            return this.tail.value;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    public boolean isFull() {
        return this.count == this.capacity;
    }

    public static void main(String[] args) {
        MyCircularLinkedListQueue myCircularQueue = new MyCircularLinkedListQueue(3);
        System.out.println(myCircularQueue.enQueue(1));; // return True
        System.out.println(myCircularQueue.enQueue(2));; // return True
        System.out.println(myCircularQueue.enQueue(3));; // return True
        System.out.println(myCircularQueue.enQueue(4));; // return False
        System.out.println(myCircularQueue.Rear());;     // return 3
        System.out.println(myCircularQueue.isFull());;   // return True
        System.out.println(myCircularQueue.deQueue());;  // return True
        System.out.println(myCircularQueue.enQueue(4));; // return True
        System.out.println(myCircularQueue.Rear());;     // return 4
    }
}