package com.lml.algorithmlearn.Array;

import java.util.HashMap;
import java.util.HashSet;
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



    public static void main(String[] args) {

        int[] array = new int[]{3,1,14,11};
        System.out.println(checkIfExistBetter(array));
    }
}
