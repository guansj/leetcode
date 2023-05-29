package com.gsj.study.leetcode.easy;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] arr = new int[]{7,8,9,11,12};

    }
    public static int firstMissingPositive(int[] nums) {
        int less1 = nums[0] - 1;
        int bigger1 = nums[0] + 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - less1 == 2){

            }
        }
        return 0;
    }
}
