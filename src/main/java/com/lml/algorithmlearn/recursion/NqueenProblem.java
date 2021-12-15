package com.lml.algorithmlearn.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NqueenProblem {

    private int globalN;
    private List<String> temp;
    private Map<String, Set<String>> attackPoint = new HashMap<>();
    List<List<String>> result = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        this.globalN = n;
        temp = new ArrayList<>(n);
        backtrackNqueen(0);
        return result;
    }

    private void backtrackNqueen(int row) {
        for (int col = 0; col < globalN; col++) {
            if (!isAttackPoint(row, col)) {
                lanceQuenen(row, col);
                if (row + 1 == globalN) {
                    List<String> add = new LinkedList<>();
                    add.addAll(temp);
                    result.add(add);
                } else {
                    backtrackNqueen(row + 1);
                }
                removeQuenen(row, col);
            }
        }
    }

    private boolean isAttackPoint(int row, int col) {
        List<Set<String>> set = new LinkedList<>();
        set.addAll(attackPoint.values());
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).contains(row + "" + col)) {
                return true;
            }
        }
        return false;
    }

    private void lanceQuenen(int row, int col) {
        Set<String> set = new HashSet<>();
        //放置横向攻击点
        for (int i = 0; i < globalN; i++) {
            set.add(row + "" + i);
        }
        //放置纵向攻击点
        for (int i = 0; i < globalN; i++) {
            set.add(i + "" + col);
        }
        //放置左斜攻击点
        int leftRow = row;
        int leftCol = col;
        while (leftRow >= 0 && leftCol <= globalN) {
            set.add(leftRow + "" + leftCol);
            leftRow--;
            leftCol++;
        }
        leftRow = row;
        leftCol = col;
        while (leftRow <= globalN && leftCol >= 0) {
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
        while (rightRow <= globalN && rightCol <= globalN) {
            set.add(rightRow + "" + rightCol);
            rightRow++;
            rightCol++;
        }
        attackPoint.put(row + "" + col, set);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < globalN; i++) {
            if (i == col) {
                stringBuilder.append("Q");
            } else {
                stringBuilder.append(".");
            }
        }
        temp.add(row, stringBuilder.toString());
    }

    private void removeQuenen(int row, int col) {
        attackPoint.remove(row + "" + col);
        temp.remove(row);
    }

    public static void main(String[] args) {
        List<List<String>> list = new NqueenProblem().solveNQueens(4);
        for (int i = 0; i < list.size(); i++) {

            List<String> stringList = list.get(i);
            for (int j = 0; j < stringList.size(); j++) {
                System.out.println(stringList.get(j));
            }
        }
    }
}
