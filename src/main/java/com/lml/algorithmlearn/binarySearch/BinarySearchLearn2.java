package com.lml.algorithmlearn.binarySearch;

public class BinarySearchLearn2 {

    public double myPow(double x, int n) {

//        if (n < 0) {
//            x = 1 / x;
//            n = Math.abs(n);
//        }
//        return myPowRecursion(x, n);
        long ln = n;
        return n > 0 ? quickMul(x, ln) : 1 / quickMul(x, -ln);
    }

    private double myPowRecursion(double x, long n) {

        if (n == 0) {
            return 1;
        }

        double y = myPowRecursion(x, n / 2);
        double result;
        if (n % 2 == 0) {
            result = y * y;
        } else {
            result = y * y * x;
        }
        return result;
    }

    private double quickMul(double x, long n) {

        double ans = 1;
        double x_contribute = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn2().myPow(2, -3));
    }
}
