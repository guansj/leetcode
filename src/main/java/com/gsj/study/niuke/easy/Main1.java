package com.gsj.study.niuke.easy;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);

        int n = sr.nextInt();
        int[][] cl = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cl[i][j] = sr.nextInt();
            }
        }
        System.out.println(bestNum(cl, n));

    }

    public static int bestNum(int[][] cl, int n) {
        return bestNum(cl, n, 0, -1);
    }

    public static int bestNum(int[][] cl, int n, int level, int lastIdx) {


        if (n == level + 1) {
            int mins = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != lastIdx && cl[level][i] < mins) {
                    mins = cl[level][i];
                }
            }
            return mins;
        }

        int min = 0;
        int sumMin = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != lastIdx) {
                min = cl[level][i] + bestNum(cl, n, level + 1, i);
                if (min < sumMin) {
                    sumMin = min;
                }
            }
        }
        return sumMin;

    }
}



/*
import java.util.Scanner;
public class Main2{
    public static void main(String[]  args){
        Scanner sr = new Scanner(System.in);

        //

        int n = sr.nextInt();
        int[][] cl = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                cl[i][j] = sr.nextInt();
            }
        }
        System.out.println(bestNum(cl, n));

    }

    public static int bestNum(int[][] cl, int n){
        int curIdx = -1;
        int sum = 0;
        for(int i = 0; i< n; i++){
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for(int j = 0; j < 3; j++){
                if(cl[i][j] < min && curIdx != j){
                    min = cl[i][j];
                    minIdx = j;
                }
            }
            curIdx = minIdx;
            sum += min;
        }
        return sum;
    }
}
 */
