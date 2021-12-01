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

    public int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {

            int temp = 0;
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    temp = j - i;
                    break;
                }
            }
            result[i] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new StackLearn().dailyTemperatures(new int[]{30,40,50,60}));
    }
}
