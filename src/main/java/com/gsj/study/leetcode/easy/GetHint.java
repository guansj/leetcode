package com.gsj.study.leetcode.easy;

import java.util.Arrays;

public class GetHint {
    public static void main(String[] args) {
        System.out.println(new GetHint().getHint("1807", "7810"));
    }

    public String getHint(String secret, String guess) {
        int n = secret.length();
        char[] result = new char[n];

        int aNum = 0;
        int bNum = 0;
        Arrays.fill(result, '0');
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                result[i] = 'A';
                aNum++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (result[i] == 'A') {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (result[j] == 'A') {
                    continue;
                }
                if (secret.charAt(i) == guess.charAt(j) && result[j] == '0') {
                    result[j] = 'B';
                    bNum++;
                    break;
                }
            }
        }
        return aNum + "A" + bNum + "B";

    }
}
