package com.gsj.study.leetcode.easy;

import java.util.Arrays;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        System.out.println(s + "-->" + lengthOfLongestSubstring(s));
        s = "bbtablud";
        System.out.println(s + "-->" + lengthOfLongestSubstring(s));
//        s = "";
//        System.out.println(s + "-->" + lengthOfLongestSubstring(s));
//        s = "pwwkew";
//        System.out.println(s + "-->" + lengthOfLongestSubstring(s));
//        s = "aab";
//        System.out.println(s + "-->" + lengthOfLongestSubstring(s));
//        s = "dvdf";
//        System.out.println(s + "-->" + lengthOfLongestSubstring(s));
//        s = "tmmzuxt";
//        System.out.println(s + "-->" + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int[] set = new int[127];
        Arrays.fill(set, -1);
        char c = (char) 0;
        int curLength = 0;
        for (i = 0; i < s.length(); ) {

            for (j = i; j < s.length(); j++) {
                c = s.charAt(j);
                if (set[(int) c] >= 0) {
                    if(set[(int) c] != j){
                        break;
                    }else{
                        continue;
                    }
                } else {
                    curLength++;
                    set[(int) c] = j;
                }
            }
            maxLength = maxLength < curLength ? curLength : maxLength;
            curLength = curLength - (set[(int) c] + 1);
            for(; i <= set[(int) c]; i++ ){
                set[s.charAt(i)] = -1;
            }



        }
        return maxLength;

    }
}
