package com.gsj.study.niuke.easy;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);

        int n = sr.nextInt();
        int m = sr.nextInt();
        int[][] cl = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                cl[i][j] = sr.nextInt();
            }
        }
        System.out.println(total(cl, n, m));

    }

    private static int total(int[][] cl, int n, int m) {
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time < cl[i][0] + cl[i][1]) {
                time = cl[i][0] + cl[i][1];
            }
        }
        int[] res = new int[time + 1];
        Arrays.fill(res, 0);
        int[] cai = new int[time + 1];

        for (int i = 0; i < n; i++) {
            cai[i] = cl[i][0] + cl[i][1];
            if (res[i] == 0) {
                res[cl[i][0] + cl[i][1]] = 1;
            }
        }

        int sum = 0;
        for (int i = 2; i < time + 1; i = i + m) {
            sum += res[i];
        }

        return sum;
    }
}