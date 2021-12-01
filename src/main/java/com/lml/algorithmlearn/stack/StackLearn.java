package com.lml.algorithmlearn.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackLearn {

    public boolean isValid(String s) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {

           if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                deque.push(s.charAt(i));
           } else {
               if (deque.isEmpty()) {
                   return false;
               }
               Character c = deque.pop();
               if ((s.charAt(i) == ')' && c != '(') || (s.charAt(i) == '}' && c != '{') || (s.charAt(i) == ']' && c != '[')) {
                    return false;
               }
           }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        // 1. Initialize a stack.
        Deque<Integer> s = new LinkedList<>();
        // 2. Push new element.
        s.push(5);
        s.push(13);
        s.push(8);
        s.push(6);
        // 3. Check if stack is empty.
        if (s.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        // 4. Pop an element.
        s.pop();
        // 5. Get the top element.
        System.out.println("The top element is: " + s.peek());
        // 6. Get the size of the stack.
        System.out.println("The size is: " + s.size());
    }
}
