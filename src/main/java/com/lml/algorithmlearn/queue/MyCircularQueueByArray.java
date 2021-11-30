package com.lml.algorithmlearn.queue;

public class MyCircularQueueByArray {

    private int[] arrays;
    private int headPoint;
    private int maxSize;
    private int size;
    public MyCircularQueueByArray(int k) {
        this.maxSize = k;
        this.arrays = new int[k];
        this.headPoint = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        } else {
            this.arrays[(this.headPoint + this.size) % this.maxSize] = value;
            this.size++;
            return true;
        }
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        } else {
            this.headPoint = (this.headPoint + 1) % this.maxSize;
            this.size --;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.arrays[this.headPoint];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return this.arrays[(this.headPoint + this.size - 1) % this.maxSize];
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }

    public static void main(String[] args) {
        MyCircularQueueByArray array = new MyCircularQueueByArray(3);
        array.enQueue(3);
        array.enQueue(9);
        array.enQueue(5);
        System.out.println(array.Rear());
        System.out.println(array.deQueue());
        array.enQueue(0);
        System.out.println(array.Front());
        System.out.println(array.Rear());
        System.out.println(array.deQueue());
        System.out.println(array.deQueue());
        System.out.println(array.deQueue());

    }
}
