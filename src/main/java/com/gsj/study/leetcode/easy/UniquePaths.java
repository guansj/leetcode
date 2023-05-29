package com.gsj.study.leetcode.easy;

public class UniquePaths {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new UniquePaths().uniquePaths(7, 3));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int uniquePaths(int m, int n) {
        int res[][] = new int[m][n];
        res[0][0] = 1;
        for (int i = 1; i < m; i++) {
            res[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            res[0][j] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        //        a[m, n] =a[m - 1, n]+a[m, n - 1];
        //        a[0, 1]=a[0, 0]
        //        a[1, 1]=a[0, 1]+a[1, 0]
        //        a[2, 0]=1
        //        a[2, 1] =a[1, 1]+a[2, 0]


        return res[m-1][n-1];
    }

    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);

    }
}
