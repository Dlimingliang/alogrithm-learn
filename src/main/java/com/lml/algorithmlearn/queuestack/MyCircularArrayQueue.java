package com.lml.algorithmlearn.queuestack;

class MyCircularArrayQueue {

    private int[] queue;
    private int head;
    private int size;


    public MyCircularArrayQueue(int k) {
        queue = new int[k];
        this.size = 0;
        this.head = 0;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            int tail = (this.head + this.size) % this.queue.length;
            this.queue[tail] = value;
            this.size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            this.head = (this.head + 1) % this.queue.length;
            this.size--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (!isEmpty()) {
            return this.queue[head];
        }
        return -1;
    }
    
    public int Rear() {
        if (!isEmpty()) {
            int tail = (this.head + this.size - 1) % this.queue.length;
            return this.queue[tail];
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.queue.length;
    }

    public static void main(String[] args) {
        MyCircularArrayQueue myCircularQueue = new MyCircularArrayQueue(3);
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