package com.gsj.study.leetcode.easy;

public class TwoNumberSumSolution {
    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(a, target);
        for(int num : result){
            System.out.println(num);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        boolean find = false;
        int i, j = 1;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        if (find) {
            int[] result = new int[2];
            result[0] = i;
            result[1] = j;
            return result;
        } else {
            return null;
        }
    }
}
