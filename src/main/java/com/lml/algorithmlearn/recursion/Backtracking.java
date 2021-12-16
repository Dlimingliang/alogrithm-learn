package com.lml.algorithmlearn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }

    public void solveSudoku(char[][] board) {

        int x = board[0].length;
        int y = board.length;
        List<List<Character>> rowCheckList = new ArrayList<>(y);
        for (int i = 0; i < y; i++) {
            rowCheckList.add(i, new LinkedList<>());
        }
        List<List<Character>> colCheckList = new ArrayList<>(x);
        for (int i = 0; i < y; i++) {
            colCheckList.add(i, new LinkedList<>());
        }
        Map<String, List<Character>> blocCheckkMap = new HashMap<>();
        backTracking(board, x, y, 0, 0, rowCheckList, colCheckList, blocCheckkMap);
        System.out.println(board);
    }

    private void backTracking(char[][] board, int x, int y, int row, int col, List<List<Character>> rowCheckList, List<List<Character>> colCheckList, Map<String, List<Character>> blocCheckkMap) {

        if (row == 9) {
            return;
        }

        if (board[row][col] != '.') {
            if (isValid(board[row][col], row, col, rowCheckList, colCheckList, blocCheckkMap)) {
                placeNum(board, board[row][col], row, col, rowCheckList, colCheckList, blocCheckkMap);
                if (col == 8) {
                    backTracking(board, x, y, row + 1, 0, rowCheckList, colCheckList, blocCheckkMap);
                } else {
                    backTracking(board, x, y, row, col + 1, rowCheckList, colCheckList, blocCheckkMap);
                }
                removeNum(board, board[row][col], row, col, rowCheckList, colCheckList, blocCheckkMap);
            }
        } else {
            for (int i = 1; i < 10; i++) {
                char num = (char)('0' + i);
                if (isValid(num, row, col, rowCheckList, colCheckList, blocCheckkMap)) {
                    placeNum(board, num, row, col, rowCheckList, colCheckList, blocCheckkMap);
                    if (col == 8) {
                        backTracking(board, x, y, row + 1, 0, rowCheckList, colCheckList, blocCheckkMap);
                    } else {
                        backTracking(board, x, y, row, col + 1, rowCheckList, colCheckList, blocCheckkMap);
                    }
                    removeNum(board, num, row, col, rowCheckList, colCheckList, blocCheckkMap);
                }
            }
        }
    }

    private boolean isValid(char num, int row, int col, List<List<Character>> rowCheckList, List<List<Character>> colCheckList, Map<String, List<Character>> blocCheckkMap) {

        List<Character> rowList = rowCheckList.get(row);
        if (rowList.contains(num)) {
            return false;
        }
        List<Character> colList = colCheckList.get(row);
        if (colList.contains(num)) {
            return false;
        }
        int rowIndex = row / 3;
        int colIndex = col / 3;
        List<Character> blockList = blocCheckkMap.getOrDefault(rowIndex + "" + colIndex, new LinkedList<>());
        if (blockList.contains(num)) {
            return false;
        }
        return true;
    }

    private void placeNum(char[][] board, char num, int row, int col, List<List<Character>> rowCheckList, List<List<Character>> colCheckList, Map<String, List<Character>> blocCheckkMap) {

        board[row][col] = num;

        List<Character> rowList = rowCheckList.get(row);
        rowList.add(num);

        List<Character> colList = colCheckList.get(row);
        colList.add(num);

        int rowIndex = row / 3;
        int colIndex = col / 3;
        String key = rowIndex + "" + colIndex;
        List<Character> blockList = blocCheckkMap.getOrDefault(key, new LinkedList<>());
        blockList.add(num);
        blocCheckkMap.put(key, blockList);
    }

    private void removeNum(char[][] board, char num, int row, int col, List<List<Character>> rowCheckList, List<List<Character>> colCheckList, Map<String, List<Character>> blocCheckkMap) {
        board[row][col] = '.';

        List<Character> rowList = rowCheckList.get(row);
        rowList.remove(new Character(num));

        List<Character> colList = colCheckList.get(row);
        colList.remove(new Character(num));

        int rowIndex = row / 3;
        int colIndex = col / 3;
        List<Character> blockList = blocCheckkMap.getOrDefault(rowIndex + "" + colIndex, new LinkedList<>());
        blockList.remove(new Character(num));
    }


    public static void main(String[] args) {
        char[] char1 = new char[]{'5','3','.','.','7','.','.','.','.'};
        char[] char2 = new char[]{'6','.','.','1','9','5','.','.','.'};
        char[] char3 = new char[]{'.','9','8','.','.','.','.','6','.'};
        char[] char4 = new char[]{'8','.','.','.','6','.','.','.','3'};
        char[] char5 = new char[]{'4','.','.','8','.','3','.','.','1'};
        char[] char6 = new char[]{'7','.','.','.','2','.','.','.','6'};
        char[] char7 = new char[]{'.','6','.','.','.','.','2','8','.'};
        char[] char8 = new char[]{'.','.','.','4','1','9','.','.','5'};
        char[] char9 = new char[]{'.','.','.','.','8','.','.','7','9'};
        new Backtracking().solveSudoku(new char[][]{char1, char2, char3, char4, char5, char6, char7, char8, char9});
    }

}
