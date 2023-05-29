package com.gsj.study.leetcode.easy;

import java.util.Arrays;

public class Keyboard {
    public static void main(String[] args) {
        System.out.println(new Keyboard().keyboard(5, 50));
    }

    public String keyboard(int k, int n) {
        int length = 10;
        int[] result = new int[length];
        Arrays.fill(result, 0);

        result[0] = 1;
        if (k <= n) {
            for (int j = 1; j <= n; j++) {
                if (j <= k) {
                    for (int l = 0; l < length; l++) {
                        if (result[l] > 0) {
                            result[l] = result[l] * 26;
                            for (int i = 0; i < length; i++) {
                                if (result[i] > 1000) {
                                    result[i + 1] = result[i + 1] + result[i] / 1000;
                                    result[i] = result[i] % 1000;
                                }
                            }
                        }
                    }


                } else {
                    for (int i = 0; i < length; i++) {
                        if (result[i] > 0) {
                            result[i] = result[i] * (26 - (j - k));
                            for (int x = 0; x < length; x++) {
                                if (result[x] > 1000) {
                                    result[x + 1] = result[x + 1] + result[x] / 1000;
                                    result[x] = result[x] % 1000;
                                }
                            }
                        }
                    }
                }

            }
        } else {
            for (int j = 1; j <= n; j++) {
                for (int i = 0; i < length; i++) {
                    if (result[i] > 0) {
                        result[i] = result[i] * 26;
                    }
                }
                for (int i = 0; i < length; i++) {
                    if (result[i] > 1000) {
                        result[i + 1] = result[i + 1] + result[i] / 1000;
                        result[i] = result[i] % 1000;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = 99; i >= 0; i--) {
            if (result[i] > 0 || start) {
                sb.append(result[i]);
                start = true;
            }
        }
        return sb.toString();
    }
}
