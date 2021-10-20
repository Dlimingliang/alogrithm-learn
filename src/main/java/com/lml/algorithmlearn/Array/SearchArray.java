package com.lml.algorithmlearn.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/20 09:07
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class SearchArray {

    public static boolean checkIfExist(int[] arr) {

        //时间复杂度O(n2)
        //空间复杂度O(1)
        int length = arr.length;
        if (arr == null || length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j
                    && (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkIfExistBetter(int[] arr) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i) {
                return true;
            }
            if (arr[i] % 2 == 0 && map.containsKey(arr[i] / 2) && map.get(arr[i] / 2) != i) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    public static boolean validMountainArray(int[] arr) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int N = arr.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && arr[i] < arr[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == N - 1;

    }



    public static void main(String[] args) {

//        int[] array = new int[]{3,1,14,11};
//        System.out.println(checkIfExistBetter(array));
        int[] MountainArray = new int[]{0,3,2,1};
        System.out.println(validMountainArray(MountainArray));
    }
}
