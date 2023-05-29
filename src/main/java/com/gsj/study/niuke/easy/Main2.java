package com.gsj.study.niuke.easy;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sr.nextInt();
        }
        System.out.println(colorNums(n, nums));
    }

    public static int colorNums(int n, int[] nums) {
        Arrays.sort(nums);
        int times = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i] <=100){
                min = Math.min(min, nums[i]);
            }else{
                continue;
            }
            for (int j = i; j < n; j++) {
                if (nums[j] <= 100 && nums[j] % min == 0){
                    nums[j] = Integer.MAX_VALUE;
                }
            }
            times++;
        }
        return times;
    }
}
