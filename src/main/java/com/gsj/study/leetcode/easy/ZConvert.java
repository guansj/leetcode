package com.gsj.study.leetcode.easy;

public class ZConvert {
    public static void main(String[] args) {
        String s = "AB";
        System.out.println(convert(s, 1));
        System.out.println(convert(s, 4));
    }

    public static String convert(String s, int numRows) {
        int length = s.length();
        if(length <= numRows || numRows == 1){
            return s;
        }
        int groupNum = 2 * numRows - 2;
        char[] cs = new char[length];

        int k=0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += groupNum) {
                cs[k++] = s.charAt(j+i);
                if (i != 0 && i != numRows - 1 && j + groupNum - i < length){
                    cs[k++] = s.charAt(j + groupNum - i);
                }

            }
        }
        return new String(cs);
    }
}
