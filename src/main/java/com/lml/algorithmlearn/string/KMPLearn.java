package com.lml.algorithmlearn.string;

public class KMPLearn {

    public static int kmp(String str, String pattern) {

        //模式串的长度为m，原串的长度为n
        //时间复杂度O(m+n)
        //空间复杂度O(m)
        //生成模式串
        int[] next = generateNextArray(pattern);
        int length = str.length();
        int j = 0;
        for (int i = 0; i < length; i++) {
            while(j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if(j == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }

    public static int[] generateNextArray(String str){

        int length = str.length();
        int[] next = new int[length];
        int j = 0;
        for (int i = 2; i < length; i++) {

            while (j != 0 && str.charAt(j) != str.charAt(i - 1)) {
                j = next[j];
            }
            if (str.charAt(j) == str.charAt(i - 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {

        //String str = "GTGTGCF";
        //System.out.println(generateNextArray(str));
        System.out.println(kmp("ACTGPACTGKACTGPACY", "ACTGPACY"));
    }
}
