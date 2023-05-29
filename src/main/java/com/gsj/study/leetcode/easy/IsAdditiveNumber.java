package com.gsj.study.leetcode.easy;

public class IsAdditiveNumber {
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("121474836472147483648"));
    }

    public static boolean isAdditiveNumber(String num) {

        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    private static boolean dfs(String num, int length, int idx, long sum, long pre, int k) {
        if (idx == length) {
            return k > 2;
        }
        for (int i = idx; i < length; i++) {
            long cur = fetchCur(num, idx, i);
            if (cur < 0) {
                continue;
            }
            if (k >= 2 && sum != cur) {
                continue;
            }
            if (dfs(num, length, i + 1, pre + cur, cur, k + 1)) {
                return true;
            }
        }
        return false;
    }

    private static long fetchCur(String num, int l, int r) {
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        long cur = 0;
        while (l <= r) {
            cur = cur * 10 + num.charAt(l++) - '0';
        }
        return cur;
    }
}
