package com.lml.algorithmlearn.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProblem {

    public int numIslandsBFS(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(r * nc + c);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.add((row -1) * nc + c);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            queue.add((row + 1) * nc + c);
                            grid[row + 1][col] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            queue.add(row * nc + c + 1);
                            grid[row][col + 1] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.add(row * nc + c - 1);
                            grid[row][col - 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

    public static void main(String[] args) {
        char[][] array = new char[][]{new char[]{'1','1','1','1','0'}, new char[]{'1','1','0','1','0'}, new char[]{'1','1','0','0','0'}, new char[]{'0','0','0','0','0'}};
        System.out.println(new QueueProblem().numIslandsBFS(array));
    }
}