package leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        map.put("IV", 4);

        int n = 0;
        int i =0;
        while(i<s.length()){
            if(i<s.length()-1){
                String t = s.substring(i,i+2);
                if(map.containsKey(t)){
                    n+= map.get(t);
                    i = i+2;
                    continue;
                }
            }
            String c = s.substring(i,i+1);
            n += map.get(String.valueOf(c));
            i++;
        }
        return n;
    }

    public static void main(String[] args){
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("MCMXCIV"));

    }
}
