package com.gsj.study.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {

    public static void main(String[] args) {
        System.out.println(new MinNumber().minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public String minNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int m = o1.length();
                int n = o2.length();
                if (m == n) {
                    return o1.compareTo(o2);
                }
                int minLength = Math.min(m, n);
                for (int i = 0; i < minLength; i++) {
                    if (o1.charAt(i) == o2.charAt(i)) {
                        continue;
                    } else if (o1.charAt(i) > o2.charAt(i)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }

                if (m > n) {
                    return compare(o1.substring(n), o2);
                } else {
                    return compare(o1, o2.substring(m));
                }


            }
        });

        StringBuilder sb = new StringBuilder();
        for (String a : s) {
            sb.append(a);
        }
        return sb.toString();
    }
}
