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

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        for (int i = m + n - 1; i >= 0; i--) {

            if (m <= 0 && n > 0) {
                nums1[i] = nums2[n - 1];
                n--;
            } else if (m > 0 && n <= 0) {
                nums1[i] = nums1[m - 1];
                m--;
            } else if (m > 0 && n > 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[i] = nums1[m - 1];
                    m--;
                } else {
                    nums1[i] = nums2[n - 1];
                    n--;
                }
            }
        }

        System.out.println(nums1);
    }

    public static void main(String[] args) {

//        int[] array = new int[]{8,4,5,0,0,0,0,7};
//        duplicateZerosBetter(array);
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
