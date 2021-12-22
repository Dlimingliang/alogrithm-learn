package com.lml.algorithmlearn.binarySearch;

public class BinarySearchLearn2 {

    public double myPow(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        return myPowRecursion(x, n);
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

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn2().myPow(2, -3));
    }
}
