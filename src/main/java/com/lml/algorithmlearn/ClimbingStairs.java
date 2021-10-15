package com.lml.algorithmlearn;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/15 10:10
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class ClimbingStairs {

    //暴力求解
    private static int climbingStairs(int i, int n) {

        //时间复杂度 O(2^n)
        //空间复杂度 O(n)

        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return climbingStairs(i +  1, n) + climbingStairs(i + 2, n);
    }

    // 加入数组缓存，降低时间复杂度
    private static int climbingStairsByArray(int n) {

        int memo[] = new int[n + 1];
        return climbingStairs(0, n, memo);
    }

    private static int climbingStairs(int i, int n, int memo[]) {

        //时间复杂度 O(n)
        //空间复杂度 O(n)
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        memo[i] = climbingStairs(i +  1, n) + climbingStairs(i + 2, n);
        return memo[i];
    }

    //动态规划
    private static int climbingStairsArray(int n) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n +1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }

    //去除数组
    private static int climbingStairs(int n) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        int one = 0, two = 1,result = 0;
        for (int i = 1; i <= n; i++) {
            result = two + one;
            one = two;
            two = result;
        }
        return result;
    }

    public static void main(String[] args) {

//        System.out.println(climbingStairs(0,3));
//        System.out.println(climbingStairsByArray(3));
//        System.out.println(climbingStairsArray(3));
        System.out.println(climbingStairs(3));
    }
}
