package leetcode.array.easy;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 */
public class FindCommonCharacters {

    public static List<String> commonChars(String[] A) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        String first = A[0];
        for(int i=0;i<first.length();i++){
            String thisStr = Character.toString(first.charAt(i));
            map.put(thisStr, map.getOrDefault(thisStr, 0) + 1);
        }

        for(int i=1;i<A.length;i++){
            Map<String, Integer> thisMap = new HashMap<>();
            String thisStr = A[i];
            for(int j=0;j<thisStr.length();j++){
                String thisChar = Character.toString(thisStr.charAt(j));
                thisMap.put(thisChar, thisMap.getOrDefault(thisChar,0)+1);
            }
            List<String> keysToRemove = new ArrayList<>();
            for(String thisChar:map.keySet()){
                if(!thisMap.containsKey(thisChar)){
                    keysToRemove.add(thisChar);
                }else{
                    int aCount = map.get(thisChar);
                    int thisCount = thisMap.get(thisChar);
                    map.put(thisChar, Math.min(aCount, thisCount));
                }
            }
            for(String toR:keysToRemove){
                map.remove(toR);
            }
        }

        for(String c:map.keySet()){
            int count = map.get(c);
            int t = 1;
            while(t<=count){
                result.add(c);
                t++;
            }
        }
        return result;
    }

    public static void main(String args[]){
        String[] s = {"cool","lock","cook"};
        List<String> result = commonChars(s);
        System.out.println(result);
    }
}
