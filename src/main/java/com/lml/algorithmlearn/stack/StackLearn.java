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

//        int length = temperatures.length;
//        int[] result = new int[length];
//        for (int i = 0; i < length; i++) {
//
//            int temp = 0;
//            for (int j = i + 1; j < length; j++) {
//                if (temperatures[j] > temperatures[i]) {
//                    temp = j - i;
//                    break;
//                }
//            }
//            result[i] = temp;
//        }
//        return result;

        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    private char[][] globalGrid;
    public int numIslands(char[][] grid) {

        //时间复杂度o(mn)
        //空间复杂度O(mn)
        this.globalGrid = grid;
        int depth = grid.length;
        int breadth = grid[0].length;
        int result = 0;
        for (int d = 0; d < depth; d++) {
            for (int b = 0; b < breadth; b++) {
                if (grid[d][b] == '1') {
                    result++;
                    setZero(d, b);
                }
            }
        }
        return result;
    }

    private void setZero(int d, int b) {

        if (d < 0 || d >= this.globalGrid.length || b < 0 || b >= this.globalGrid[0].length || this.globalGrid[d][b] == '0') {
            return;
        }
        this.globalGrid[d][b] = '0';
        setZero(d - 1, b);
        setZero(d + 1, b);
        setZero(d, b - 1);
        setZero(d, b + 1);
    }

    private int result = 0;
    private int[] globalNums;
    public int findTargetSumWays(int[] nums, int target) {

        int depth = nums.length -1;
        this.globalNums = nums;
        findTargetSumWaysRecursion(0, depth, target);
        return result;
    }

    private void findTargetSumWaysRecursion(int nums, int depth, int target) {

        if (depth < 0) {
            if (nums== target) {
                result ++;
            }
        } else {
            findTargetSumWaysRecursion(nums + this.globalNums[depth], depth - 1, target);
            findTargetSumWaysRecursion(nums - this.globalNums[depth], depth - 1, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new StackLearn().findTargetSumWays(new int[]{1,1}, 1));
    }
}
