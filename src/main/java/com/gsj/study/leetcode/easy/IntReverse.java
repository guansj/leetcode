package com.gsj.study.leetcode.easy;

public class IntReverse {
    public static void main(String[] args) {

        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        if(x < 0){
            return -1 * reverse(-1 * x);
        }
        if(Integer.MIN_VALUE == x){
            return 0;
        }
        int bit = 1;
        int tmp = x;
        while(tmp / 10 > 0){
            tmp = tmp /10;
            bit++;
        }
        int[] s = new int[bit];
        for(int i = bit - 1; i >=0; i--){
            s[i] = x %10;
            x = x / 10;
        }

        long n = s[bit - 1];
        for(int i = bit - 2; i >=0; i--){
            n = n * 10 + s[i];
        }
        return Integer.MAX_VALUE < n ? 0 : (int)n;
    }
}
