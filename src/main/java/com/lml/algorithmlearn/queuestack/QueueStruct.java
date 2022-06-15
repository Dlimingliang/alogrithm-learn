package com.lml.algorithmlearn.queuestack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class QueueStruct {

    public static int numIslands(char[][] grid) {

        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] == '1') {
                    int value = y + x * n;
                    queue.offer(value);
                    result++;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int queueValue = queue.poll();
                            visited.add(queueValue);
                            int tempX = queueValue / n;
                            int tempY = queueValue % n;
                            grid[tempY][tempX] = '0';

                            //添加上下左右节点
                            if (tempY - 1 >= 0 && grid[tempY - 1][tempX] == '1') {
                                int tempValue = tempY - 1 + tempX * n;
                                if (!visited.contains(tempValue)) {
                                    queue.offer(tempValue);
                                }

                            }
                            if (tempY + 1 < n && grid[tempY + 1][tempX] == '1') {
                                int tempValue = tempY + 1 + tempX * n;
                                if (!visited.contains(tempValue)) {
                                    queue.offer(tempValue);
                                }
                            }
                            if (tempX - 1 >= 0 && grid[tempY][tempX - 1] == '1') {
                                int tempValue = tempY + (tempX - 1) * n;
                                if (!visited.contains(tempValue)) {
                                    queue.offer(tempValue);
                                }
                            }
                            if (tempX + 1 < m && grid[tempY][tempX + 1] == '1') {
                                int tempValue = tempY + (tempX + 1) * n;
                                if (!visited.contains(tempValue)) {
                                    queue.offer(tempValue);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
}
