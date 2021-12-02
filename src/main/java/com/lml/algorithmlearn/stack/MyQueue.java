package com.lml.algorithmlearn.stack;

import java.util.Deque;
import java.util.LinkedList;

//使用俩个栈，实现先入先出队列
public class MyQueue {

    Deque<Integer> intDeque;
    Deque<Integer> outDeque;
    public MyQueue() {
        this.intDeque = new LinkedList<>();
        this.outDeque = new LinkedList<>();
    }

    public void push(int x) {
        this.intDeque.push(x);
    }

    public int pop() {
        if (outDeque.isEmpty()) {
            while (!intDeque.isEmpty()) {
                outDeque.push(intDeque.pop());
            }
        }
        return outDeque.pop();
    }

    public int peek() {
        if (outDeque.isEmpty()) {
            while (!intDeque.isEmpty()) {
                outDeque.push(intDeque.pop());
            }
        }
        return outDeque.peek();
    }

    public boolean empty() {
        return intDeque.isEmpty() && outDeque.isEmpty();
    }
}
