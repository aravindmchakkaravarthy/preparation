package leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(count.get(c) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        FirstUniqueCharacterInAString f = new FirstUniqueCharacterInAString();
        System.out.println(f.firstUniqChar("aadadaad"));
        System.out.println(f.firstUniqChar("eeltcode"));
    }
}
