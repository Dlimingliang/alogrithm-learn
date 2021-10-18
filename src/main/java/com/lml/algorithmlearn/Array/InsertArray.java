package com.lml.algorithmlearn.Array;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/18 09:12
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class InsertArray {

    public static void duplicateZeros(int[] arr) {

        //时间复杂度 O(n^2)
        //空间复杂度 O(1)
        int length = arr.length, currentIndex = -2;
        for (int i = 0; i < length; i++) {
            //复制过的元素跳过
            if (i == currentIndex + 1) {
                continue;
            }
            if (i == length - 1) {
                break;
            }
            if (arr[i] == 0) {
                currentIndex = i;
                for (int j = length -1; j > i + 1; j--) {
                    arr[j] = arr[j-1];
                }
                arr[i + 1] = 0;
            }
        }
        System.out.println(arr);
    }

    public static void duplicateZerosBetter(int[] arr) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int length = arr.length, moveNum = 0;
        for (int i = 0; i < length - moveNum; i++) {

            if (arr[i] == 0) {

                if (i == length - 1 - moveNum) {
                    arr[length -1] = 0;
                    length = length - 1;
                    break;
                }

                moveNum++;
            }
        }

        int leftLength = length - 1 - moveNum;
        for (int i = leftLength; i >= 0; i--) {

            if (arr[i] == 0) {
                arr[i + moveNum] = 0;
                moveNum--;
                arr[i + moveNum] = 0;
            } else {
                arr[i + moveNum] = arr[i];
            }
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {

        int[] array = new int[]{8,4,5,0,0,0,0,7};
        duplicateZerosBetter(array);
    }
}
