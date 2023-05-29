package com.gsj.study.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreIpAddresses {

    public static void main(String[] args) {
        List<String> list = new RestoreIpAddresses().restoreIpAddresses("25525511135");
        if (list != null) {
            for (String ip : list) {
                System.out.println(ip);
            }
        }

    }

    public List<String> restoreIpAddresses(String s) {
        Map<Integer, Map> map = restoreIpAddresses(s, 4, 0);
        return convertToString(map);

    }

    private List<String> convertToString(Map<Integer, Map> map) {
        List<String> res = new ArrayList<String>();
        if (map == null) {
            return null;
        }
        for (Map.Entry<Integer, Map> entry : map.entrySet()) {

            if (entry.getValue() != null) {
                for (String line : convertToString((Map<Integer, Map>) entry.getValue())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(entry.getKey()).append(".");
                    sb.append(line);
                    res.add(sb.toString());
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey()).append(".");
                res.add(sb.substring(0, sb.length() - 1));
            }
        }
        return res;
    }

    public Map<Integer, Map> restoreIpAddresses(String s, int n, int index) {
        Map<Integer, Map> map = new HashMap<Integer, Map>();
        if (n == 1 && s.length() - index > 3) {
            return map;
        }
        for (int i = 1; i <= 3; i++) {
            int num = getNumber(s, index, i);
            if (num >= 0 && num <= 255) {
                if (n > 1) {
                    Map<Integer, Map> integerMapMap = restoreIpAddresses(s, n - 1, index + i);
                    if (integerMapMap != null && !integerMapMap.isEmpty()) {
                        map.put(num, integerMapMap);
                    }
                } else if(s.length() - index - i == 0){
                    map.put(num, null);
                }
            }
        }
        return map;
    }

    private int getNumber(String s, int index, int length) {
        if (s.length() < index + length) {
            return -1;
        }
        int num = 0;
        String c = s.substring(index, index + length);
        if (c.startsWith("0") && length > 1) {
            num = -1;
        } else {
            num = num * 10 + Integer.parseInt(c);
        }
        return num;
    }
}
