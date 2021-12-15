package com.lml.algorithmlearn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backtracking {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solutions = new ArrayList<List<String>>();
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    private void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {

        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int col = 0; col < n; col++) {

                if (columns.contains(col)) {
                    continue;
                }
                int diagonal1 = row - col;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + col;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                queens[row] = col;
                columns.add(col);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n , row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(col);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        new Backtracking().solveNQueens(4);
    }

}
