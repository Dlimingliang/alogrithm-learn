package com.lml.algorithmlearn.string;

public class StringQuestion {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        String result = "";
        int aLength = a.length();
        int bLength = b.length();
        int array = 0;
        int n = Math.max(aLength, bLength);
        for (int i = 0; i < n; i++) {
            if (i < aLength) {
                array += a.charAt(aLength -i-1) - '0';
            }
            if (i < bLength) {
                array += b.charAt(bLength-i-1) - '0';
            }
            result = (array % 2) + result;
            array /= 2;
        }
        if (array > 0) {
            result = "1" + result;
        }
        return result;
    }
}
