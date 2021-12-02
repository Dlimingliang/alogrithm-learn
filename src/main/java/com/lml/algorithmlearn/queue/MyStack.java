package com.lml.algorithmlearn.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> intQueue;
    Queue<Integer> outQueue;
    public MyStack() {
        intQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    public void push(int x) {
        intQueue.offer(x);
        while(!outQueue.isEmpty()) {
            intQueue.offer(outQueue.poll());
        }
        Queue<Integer> temp = outQueue;
        outQueue = intQueue;
        intQueue = temp;
    }

    public int pop() {
        return outQueue.poll();
    }

    public int top() {
        return outQueue.peek();
    }

    public boolean empty() {
        return outQueue.isEmpty();
    }

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
