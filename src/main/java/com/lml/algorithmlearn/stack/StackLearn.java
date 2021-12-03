package com.lml.algorithmlearn.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    public String decodeString(String s) {

//        int length = s.length();
//        Deque<String> stringDeque = new LinkedList<>();
//        Deque<Integer> integerDeque = new LinkedList<>();
//        StringBuilder multiBuilder = new StringBuilder();
//        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//            if (ch >= '0' && ch <= '9') {
//                multiBuilder.append(ch);
//            }else if (ch == '[') {
//                integerDeque.push(Integer.valueOf(multiBuilder.toString()));
//                stringDeque.push(res.toString());
//                multiBuilder = new StringBuilder();
//                res = new StringBuilder();
//            }else if (ch == ']') {
//                String tempString = stringDeque.poll();
//                Integer tempInt = integerDeque.poll();
//                StringBuilder tempRes = new StringBuilder();
//                tempRes.append(tempString);
//                for (int j = 0; j < tempInt; j++) {
//                    tempRes.append(res);
//                }
//                res = tempRes;
//            } else {
//                res.append(ch);
//            }
//        }
//        return res.toString();
        return decodeStringRecursion(s, 0)[0];
    }

    private String[] decodeStringRecursion(String s, int i) {

        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(ch));
            }else if (ch == '[') {
                String[] tmp = decodeStringRecursion(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }else if (ch == ']') {
                return new String[] { String.valueOf(i), res.toString() };
            } else {
                res.append(ch);
            }
            i++;
        }
        return new String[] { res.toString() };
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {

        //时间复杂度O(mn)
        //空间复杂度O(mn)
        int depth = mat.length;
        int breadth = mat[0].length;
        boolean[][] visited = new boolean[depth][breadth];
        int[][] result = new int[depth][breadth];
        Queue<int[]> queue = new LinkedList<>();
        for (int d = 0; d < depth; d++) {
            for (int b = 0; b < breadth; b++) {
                if (mat[d][b] == 0) {
                    queue.add(new int[]{d, b});
                    visited[d][b] = true;
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] value = queue.poll();
            int i = value[0], j = value[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k][0];
                int nj = j + dirs[k][1];
                if (ni >=0 && ni < depth && nj >=0 && nj < breadth && !visited[ni][nj]) {
                    result[ni][nj] = result[i][j] + 1;
                    queue.offer(new int[]{ni,nj});
                    visited[ni][nj] = true;
                }
            }
        }

        return result;

        //d为数组的个数，b为数组中每个数组的长度
        //时间复杂度O(mn) 但是超时
        //空间复杂度O(4)
//        int depth = mat.length;
//        int breadth = mat[0].length;
//        int [][] result = new int[depth][breadth];
//        for (int d = 0; d < depth; d++) {
//            for (int b = 0; b < breadth; b++) {
//                int currentValue = mat[d][b];
//                if (currentValue == 0) {
//                    result[d][b] = 0;
//                } else {
//                    Queue<Integer> neighbors = new LinkedList<>();
//                    neighbors.add(d * breadth + b);
//                    int step = 0;
//                    while (!neighbors.isEmpty()) {
//                        int size = neighbors.size();
//                        step++;
//                        for (int i = 0; i < size; i++) {
//                            int id = neighbors.remove();
//                            int row = id / breadth;
//                            int col = id % breadth;
//                            if (row - 1 >= 0) {
//                                if (mat[row-1][col] == 0) {
//                                    result[d][b] = step;
//                                    neighbors.clear();
//                                    break;
//                                } else {
//                                    neighbors.add((row-1) * breadth + col);
//                                }
//                            }
//                            if (row + 1 < depth) {
//                                if (mat[row+1][col] == 0) {
//                                    result[d][b] = step;
//                                    neighbors.clear();
//                                    break;
//                                } else {
//                                    neighbors.add((row+1) * breadth + col);
//                                }
//                            }
//                            if (col - 1 >= 0) {
//                                if (mat[row][col-1] == 0) {
//                                    result[d][b] = step;
//                                    neighbors.clear();
//                                    break;
//                                } else {
//                                    neighbors.add(row * breadth + col-1);
//                                }
//
//                            }
//                            if (col + 1 < breadth) {
//                                if (mat[row][col+1] == 0) {
//                                    result[d][b] = step;
//                                    neighbors.clear();
//                                    break;
//                                } else {
//                                    neighbors.add(row * breadth + col+1);
//                                }
//
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
    }

    public static void main(String[] args) {
        new StackLearn().updateMatrix(new int[][]{new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1}, new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1}, new int[]{0,0,0}});
    }
}
