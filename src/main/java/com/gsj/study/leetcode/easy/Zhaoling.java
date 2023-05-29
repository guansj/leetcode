package com.gsj.study.leetcode.easy;

public class Zhaoling {
    public static void main(String[] args) {
        int[] a = new int[]{5, 5, 10, 20};
        System.out.println(lemonadeChange(a));
        int[] b = new int[]{10,10,20};
        System.out.println(lemonadeChange(b));
        int[] c = new int[]{5,5,10,10,20};
        System.out.println(lemonadeChange(c));
    }

    public static boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;
        for(int i =0; i<bills.length;i++){
            if(bills[i] == 5 ){
                fiveNum++;
            }else if(bills[i] == 10){
                if(fiveNum <= 0){
                    return false;
                }
                tenNum++;
                fiveNum--;
            }else if(bills[i] == 20){
                if(fiveNum <= 0 || (tenNum == 0 && fiveNum <= 2)){
                    return false;
                }
                if(tenNum > 0){
                    tenNum--;
                    fiveNum--;
                }else{
                    fiveNum = fiveNum - 3;
                }
            }
        }
        return true;

    }
}
