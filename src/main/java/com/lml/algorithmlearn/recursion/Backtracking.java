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

    private boolean soduvalid = false;
    private List<int[]> spaces = new ArrayList<int[]>();
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

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    placeNum(board, board[i][j], i, j, rowCheckList, colCheckList, blocCheckkMap);
                }
            }
        }

        backTracking(board, 0, rowCheckList, colCheckList, blocCheckkMap);
        System.out.println(board);
    }

    private void backTracking(char[][] board, int n, List<List<Character>> rowCheckList, List<List<Character>> colCheckList, Map<String, List<Character>> blocCheckkMap) {

        if (n == spaces.size()) {
            soduvalid = true;
            return;
        }

        int[] space = spaces.get(n);
        int i = space[0], j = space[1];
        for (int k = 0; k < 9 && !soduvalid; k++) {

            char ch = (char) (k + '0' + 1);
            if (isValid(ch, i, j, rowCheckList, colCheckList, blocCheckkMap)) {
                placeNum(board, ch, i, j, rowCheckList, colCheckList, blocCheckkMap);
                backTracking(board, n + 1, rowCheckList, colCheckList, blocCheckkMap);
                removeNum(board, ch, i, j, rowCheckList, colCheckList, blocCheckkMap);
            }
        }

    }

    private boolean isValid(char num, int row, int col, List<List<Character>> rowCheckList, List<List<Character>> colCheckList, Map<String, List<Character>> blocCheckkMap) {

        List<Character> rowList = rowCheckList.get(row);
        if (rowList.contains(num)) {
            return false;
        }
        List<Character> colList = colCheckList.get(col);
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
        rowList.add(new Character(num));

        List<Character> colList = colCheckList.get(col);
        colList.add(new Character(num));

        int rowIndex = row / 3;
        int colIndex = col / 3;
        String key = rowIndex + "" + colIndex;
        List<Character> blockList = blocCheckkMap.getOrDefault(key, new LinkedList<>());
        blockList.add(num);
        blocCheckkMap.put(key, blockList);
    }

    private void removeNum(char[][] board, char num, int row, int col, List<List<Character>> rowCheckList, List<List<Character>> colCheckList, Map<String, List<Character>> blocCheckkMap) {

        List<Character> rowList = rowCheckList.get(row);
        rowList.remove(new Character(num));

        List<Character> colList = colCheckList.get(col);
        colList.remove(new Character(num));

        int rowIndex = row / 3;
        int colIndex = col / 3;
        List<Character> blockList = blocCheckkMap.getOrDefault(rowIndex + "" + colIndex, new LinkedList<>());
        blockList.remove(new Character(num));
    }

    List<List<Integer>> result = new LinkedList<>();
    int globalK;
    int globalN;
    int maxStart;
    Integer[] combineNum;
    public List<List<Integer>> combine(int n, int k) {

        maxStart = n - k + 1;
        globalK = k;
        globalN = n;
        combineNum = new Integer[k];
        for (int i = 0; i < k; i++) {
            combineNum[i] = 0;
        }
        combineBacktracking(0);
        return result;
    }

    private void combineBacktracking(int index) {

        if (index == globalK) {
            result.add(Arrays.asList(Arrays.copyOf(combineNum, combineNum.length)));
            return;
        }

        for (int val = 1; val <= globalN; val++) {
            if (isValidCombine(index, val)){
                lanceNum(index, val);
                combineBacktracking(index + 1);
                removeNum(index);
            }
        }
    }

    private boolean isValidCombine(int index, int val) {

        if (index > 0 && val <= combineNum[index - 1]) {
            return false;
        }

        if (index == 0 && val > maxStart) {
            return false;
        }

        for (int i = 0; i < combineNum.length; i++) {
            if (val == combineNum[i]) {
                return false;
            }
        }

        return true;
    }

    private void lanceNum(int index, int val) {
        combineNum[index] = val;
    }

    private void removeNum(int index){
        combineNum[index] = 0;
    }


    public static void main(String[] args) {
//        char[] char1 = new char[]{'5','3','.','.','7','.','.','.','.'};
//        char[] char2 = new char[]{'6','.','.','1','9','5','.','.','.'};
//        char[] char3 = new char[]{'.','9','8','.','.','.','.','6','.'};
//        char[] char4 = new char[]{'8','.','.','.','6','.','.','.','3'};
//        char[] char5 = new char[]{'4','.','.','8','.','3','.','.','1'};
//        char[] char6 = new char[]{'7','.','.','.','2','.','.','.','6'};
//        char[] char7 = new char[]{'.','6','.','.','.','.','2','8','.'};
//        char[] char8 = new char[]{'.','.','.','4','1','9','.','.','5'};
//        char[] char9 = new char[]{'.','.','.','.','8','.','.','7','9'};
//        new Backtracking().solveSudoku(new char[][]{char1, char2, char3, char4, char5, char6, char7, char8, char9});
        new Backtracking().combine(1,1);
    }

}
