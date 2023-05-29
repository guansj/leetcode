

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        BufferedReader sr = new BufferedReader(new InputStreamReader(System.in)) {
        };
        String nm[] = sr.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int max = 0;
        while (m-- > 0) {
            String ed[] = sr.readLine().split("\\s");
            int v1 = Integer.parseInt(ed[0]);
            int v2 = Integer.parseInt(ed[1]);
            Integer numV1 = map.get(v1);
            Integer numV2 = map.get(v2);
            if(numV1 == null){
                numV1 = 0;
            }
            if(numV2 == null){
                numV2 = 0;
            }
            numV1++;
            numV2++;
            map.put(v1, numV1);
            map.put(v2, numV2);
            max = Math.max(max, Math.max(numV1, numV2));
        }
        int maxNum = 0;
        if(max == 4){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == max){
                    maxNum++;
                }else if(entry.getValue() > 2 ){
                    System.out.println("NotValid");
                }
            }
            if(maxNum > 1){
                System.out.println("NotValid");
            }else{
                System.out.println("X");
            }

        }else if(max == 3){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == max){
                    maxNum++;
                }else if(entry.getValue() > 2 ){
                    System.out.println("NotValid");
                }
            }
            if(maxNum > 1){
                System.out.println("NotValid");
            }else{
                System.out.println("Y");
            }
        }else if(max == 2){
            System.out.println("I");
        }else{
            System.out.println("NotValid");
        }
    }



//    public static void main(String[] args) throws IOException {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("zero", "0");
//        map.put("two", "2");
//        map.put("four", "4");
//        map.put("six", "6");
//        map.put("nine", "9");
//        map.put("0", "0");
//        map.put("2", "2");
//        map.put("4", "4");
//        map.put("6", "6");
//        map.put("9", "9");
//        Set<String> set = new HashSet<String>();
//        set.add("zero");
//        set.add("two");
//        set.add("four");
//        set.add("six");
//        set.add("nine");
//        set.add("zero");
//        set.add("0");
//        set.add("2");
//        set.add("4");
//        set.add("6");
//        set.add("9");
//
//        BufferedReader sr = new BufferedReader(new InputStreamReader(System.in)) {
//        };
//        int num = Integer.parseInt(sr.readLine());
//        List<String> lines = new ArrayList<String>();
//        while (num-- > 0) {
//            String line = sr.readLine();
//            lines.add(line);
//        }
//        for(String line : lines) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < line.length();) {
//                boolean find = false;
//                int length = 1;
//
//                for (; length <= 4; length++) {
//                    String s = line.substring(i, Math.min(i + length, line.length()));
//                    if (set.contains(s)) {
//                        sb.append(map.get(s));
//                        find = true;
//                        break;
//                    }
//                }
//
//                if(find){
//                    i += length;
//                }else{
//                    i++;
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }

}