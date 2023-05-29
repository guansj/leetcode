package com.gsj.study.leetcode.easy;

import java.util.Arrays;

public class CountVowelStrings {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(33));
    }

    public static int countVowelStrings(int n) {
        if (n == 1) {
            return 5;
        }
        int[] res = new int[5];
        Arrays.fill(res, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 5; j > 1; j--) {
                res[j - 2] = res[j - 2] + res[j - 1];
            }
        }
        int total = 0;
        for(int i=0; i<5; i++){
            total += res[i];
        }
        return total;

    }

}
