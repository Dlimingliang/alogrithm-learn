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

    public boolean isPerfectSquare(int num) {

        long left = 1, right = num;
        while (left <= right) {

            long mid = left + (right - left) / 2;
            long midNum = mid * mid;
            if (midNum == num) {
                return true;
            } else if (midNum < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            char midChar = letters[mid];
            if (midChar <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(left != letters.length && letters[left] == target) {
            return left + 1 == letters.length ? letters[0] : letters[left + 1];
        };
        return left == letters.length ? letters[0] : letters[left];
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchLearn2().nextGreatestLetter(new char[]{'e', 'e', 'n', 'n'}, 'n'));
    }
}
