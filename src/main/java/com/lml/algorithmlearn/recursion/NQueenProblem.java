package com.lml.algorithmlearn.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NQueenProblem {

    private Map<String, Set<String>> attackPoint = new HashMap<>();
    public int totalNQueens(int n) {
        return backtrackNqueen(0, 0, n);
    }

    private int backtrackNqueen(int row, int count, int n) {

        for (int col = 0; col < n; col++) {

            if (!isNotUnderAttack(row, col)) {
                placeQueen(row, col, n);
                if (row + 1 == n) {
                    count += 1;
                } else {
                    count = backtrackNqueen(row + 1, count, n);
                }
                removeQueen(row, col);
            }
        }
        return count;
    }

    private boolean isNotUnderAttack(int row, int col) {

        List<Set<String>> set = new LinkedList<>();
        set.addAll(attackPoint.values());
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).contains(row + "" + col)) {
                return true;
            }
        }
        return false;
    }

    private void placeQueen(int row, int col, int n) {

        Set<String> set = new HashSet<>();
        //放置横向攻击点
        for (int i = 0; i < n; i++) {
            set.add(row + "" + i);
        }
        //放置纵向攻击点
        for (int i = 0; i < n; i++) {
            set.add(i + "" + col);
        }
        //放置左斜攻击点
        int leftRow = row;
        int leftCol = col;
        while (leftRow >= 0 && leftCol <= n) {
            set.add(leftRow + "" + leftCol);
            leftRow--;
            leftCol++;
        }
        leftRow = row;
        leftCol = col;
        while (leftRow <= n && leftCol >= 0) {
            set.add(leftRow + "" + leftCol);
            leftRow++;
            leftCol--;
        }
        //放置右斜攻击点
        int rightRow = row;
        int rightCol = col;
        while (rightRow >= 0 && rightCol >= 0) {
            set.add(rightRow + "" + rightCol);
            rightRow--;
            rightCol--;
        }
        rightRow = row;
        rightCol = col;
        while (rightRow <= n && rightCol <= n) {
            set.add(rightRow + "" + rightCol);
            rightRow++;
            rightCol++;
        }
        attackPoint.put(row + "" + col, set);
    }

    private void removeQueen(int row, int col) {
        attackPoint.remove(row + "" + col);
    }

    public static void main(String[] args) {
        System.out.println(new NQueenProblem().totalNQueens(1));
    }
}
