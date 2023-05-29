package com.gsj.study.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        dict.add("aaaaaaaaaa");
        System.out.println(new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> table = new HashMap<String, Boolean>();
        int minLength = s.length();
        for (String word : wordDict) {
            table.put(word, true);
            minLength = Math.min(minLength, word.length());
        }

        return wordBreak(s, table,  s.length(), minLength);
    }


    public boolean wordBreak(String s,  Map<String, Boolean> table,  int end, int minLength) {
        if(table.containsKey(s.substring(0, end))){
            return true;
        }
        for(int i = end - minLength; i >= 0; i--){
            if(table.containsKey(s.substring(i, end)) && wordBreak(s, table, i, minLength)){
                return true;
            }
        }
        return false;

    }

    public boolean wordBreakDps(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Map<String, Boolean> table = new HashMap<String, Boolean>();
        for (String word : wordDict) {
            table.put(word, true);
        }

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && table.containsKey(s.substring(j, i));
                if(dp[i]){
                    break;
                }
            }

        }
        return dp[s.length()];
    }


}
