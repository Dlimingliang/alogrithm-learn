package com.lml.algorithmlearn.array;

public class DoubleArray {

    public static void rotate(int[][] matrix) {

        //时间复杂度O(nlogn)
        //空间复杂度O(1)
        int temp, size = matrix.length, length = size - 1;
        for (int j = 0; j < size / 2; j++) {
            for (int i = j; i < length - j; i++) {
                temp = matrix[length - i][0 + j];
                matrix[length - i][0 + j] = matrix[length - j][length - i];
                matrix[length - j][length - i] = matrix[i][length - j];
                matrix[i][length - j] = matrix[0 + j][i];
                matrix[0 + j][i] = temp;
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        rotate(matrix);
    }
}
