package com.gsj.study.leetcode.easy;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(243));
        System.out.println(isPowerOfThree(1162261466));
    }

    public static boolean isPowerOfThree(int n) {
        return n > 1 && 1162261467 % n == 0;
    }
}
