package com.gsj.study.leetcode.easy;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] a = new int[1][2];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = 0;
            }
        }
        a[0][0] = 1;
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(a));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int res[][] = new int[m][n];
        res[0][0] = 1;
        if (obstacleGrid[0][0] == 1) {
            res[0][0] = 0;
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                for (; i < m; i++) {
                    res[i][0] = 0;
                }
            } else {
                res[i][0] = res[i - 1][0];
            }

        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                for (; j < n; j++) {
                    res[0][j] = 0;
                }
            } else {
                res[0][j] = res[0][j - 1];
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        res[i][j] = 1;
                    } else {
                        res[i][j] = res[i - 1][j] + res[i][j - 1];
                    }
                }
            }
        }


        return res[m - 1][n - 1];
    }
}
