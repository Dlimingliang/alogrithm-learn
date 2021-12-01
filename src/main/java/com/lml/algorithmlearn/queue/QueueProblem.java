package com.lml.algorithmlearn.queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class QueueProblem {

    public int numIslandsBFS(char[][] grid) {

        //m为数组的长度，n为数组中元素数组的长度
        //时间复杂度O(mn)
        //空间复杂度O(min(m,n))
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }

    public int openLock(String[] deadends, String target) {
        String initialString = "0000";
        int count = 0;
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(initialString)) {
            return -1;
        }
        Set<String> stringSet = new HashSet<>();
        stringSet.add(initialString);
        Queue<String> queue = new LinkedList<>();
        queue.offer(initialString);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(target)) {
                    return count;
                } else {
                    //添加4个位置每个位置+1-1的值
                    for (int j = 0; j < target.length(); j++) {
                        char ch = temp.charAt(j);
                        String strAdd = temp.substring(0, j) + (ch == '9' ? 0 : ch - '0' + 1) + temp.substring(j + 1);
                        String strSub = temp.substring(0, j) + (ch == '0' ? 9 : ch - '0' - 1) + temp.substring(j + 1);
                        if (!deadSet.contains(strAdd) && !stringSet.contains(strAdd)) {
                            stringSet.add(strAdd);
                            queue.add(strAdd);
                        }
                        if (!deadSet.contains(strSub) && !stringSet.contains(strSub)) {
                            stringSet.add(strSub);
                            queue.add(strSub);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public int numSquares(int n) {

        if (n == 1) {
            return 1;
        }

        int step = 1;
        while (Math.pow(step, 2) <= n) {
            step++;
        }

        Set<Integer> visitSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visitSet.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int j = 1; j < step; j++) {

                    int value = (int) (temp + Math.pow(j, 2));
                    if (value == n) {
                        return count;
                    }
                    if (!visitSet.contains(value)) {
                        visitSet.add(value);
                        queue.add(value);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new QueueProblem().numSquares(2));
    }
}
