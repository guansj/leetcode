package com.gsj.study.huawei;

public class Huawei2 {

    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        arr[0][0] = 10;
        arr[0][1] = 20;
        arr[0][2] = 30;
        arr[1][0] = 30;
        arr[1][1] = 15;
        arr[1][2] = 10;




        int[][] res = new Huawei2().compare(arr);
        for(int i = 0 ; i < 2; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(res[i][j]+", ");
            }
            System.out.println();
        }
    }

    private int[][] compare(int[][] arr) {

        if(arr == null || arr[0] == null){
            return null;
        }

        int m = arr.length;
        int n = arr[0].length;

        int[][] res = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){

                res[i][j] = 0;

                for(int l = 0; l < n; l++){
                    if(arr[i][l] > arr[i][j]){
                        res[i][j]++;
                    }
                }

                for(int k = 0; k < m; k++){
                    if(arr[k][j] > arr[i][j]){
                        res[i][j]++;
                    }
                }
            }
        }
        return res;
    }
}
