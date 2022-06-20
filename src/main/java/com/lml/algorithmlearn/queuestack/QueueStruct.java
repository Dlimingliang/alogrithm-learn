package com.lml.algorithmlearn.queuestack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class QueueStruct {

    public static int numIslands(char[][] grid) {

        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] == '1') {
                    int value = y + x * n;
                    queue.offer(value);
                    grid[y][x] = '0';
                    result++;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int queueValue = queue.poll();
                            int tempX = queueValue / n;
                            int tempY = queueValue % n;
                            //添加上下左右节点
                            if (tempY - 1 >= 0 && grid[tempY - 1][tempX] == '1') {
                                int tempValue = tempY - 1 + tempX * n;
                                grid[tempY - 1][tempX] = '0';
                                queue.offer(tempValue);
                            }
                            if (tempY + 1 < n && grid[tempY + 1][tempX] == '1') {
                                int tempValue = tempY + 1 + tempX * n;
                                grid[tempY + 1][tempX] = '0';
                                queue.offer(tempValue);
                            }
                            if (tempX - 1 >= 0 && grid[tempY][tempX - 1] == '1') {
                                int tempValue = tempY + (tempX - 1) * n;
                                grid[tempY][tempX - 1] = '0';
                                queue.offer(tempValue);
                            }
                            if (tempX + 1 < m && grid[tempY][tempX + 1] == '1') {
                                int tempValue = tempY + (tempX + 1) * n;
                                grid[tempY][tempX + 1] = '0';
                                queue.offer(tempValue);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public int openLock(String[] deadends, String target) {

        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>();
        dead.addAll(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }

        int result = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                for (String nextStatus : get(temp)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return result;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }

        }
        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }


    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
//                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
//                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
//                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
//                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
//                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
//                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
//                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
//                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
//                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
//        System.out.println(numIslands(grid));
        System.out.println(new QueueStruct().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
    }
}
