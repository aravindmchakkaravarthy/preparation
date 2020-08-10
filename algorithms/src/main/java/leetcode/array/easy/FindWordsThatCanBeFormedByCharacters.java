package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {

    public static int countCharacters(String[] words, String chars) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<chars.length();i++){
            Character c = chars.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(String thisString:words){
            Map<Character, Integer> thisMap = new HashMap<>();
            boolean valid = true;
            for(int i=0;i<thisString.length();i++){
                Character c = thisString.charAt(i);
                thisMap.put(c, thisMap.getOrDefault(c, 0)+1);
                valid = map.containsKey(c) && thisMap.get(c) <= map.get(c);
                if(!valid){
                    break;
                }
            }
            if(valid){
                ans += thisString.length();
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String[] q = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(q, chars));
    }
}
