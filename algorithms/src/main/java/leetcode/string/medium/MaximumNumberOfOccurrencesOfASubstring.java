package leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return the maximum number of ocurrences of any substring under the following rules:
 *
 * The number of unique characters in the substring must be less than or equal to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 *
 *
 * Example 1:
 *
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 ocurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 * Example 2:
 *
 * Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * Output: 2
 * Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 * Example 3:
 *
 * Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * Output: 3
 * Example 4:
 *
 * Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s only contains lowercase English letters.
 */
public class MaximumNumberOfOccurrencesOfASubstring {

    public int maxFreq2(String s, int maxLetters, int minSize, int maxSize){
        Map<String, Integer> map = new HashMap<>();
        int[] arr = new int[26];
        int count = 0;
        int max = 0;
        for(int l=0,i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(arr[c-'a']==0) count++;
            arr[c-'a'] ++;
            if(i+1>=minSize){
                if(count<=maxLetters){
                    String sub = s.substring(l,i+1);
                    map.put(sub, map.getOrDefault(sub,0)+1);
                    max = Math.max(max, map.get(sub));
                }
                char lc = s.charAt(l++);
                arr[lc-'a'] --;
                if(arr[lc-'a']==0) count--;
            }
        }
        return max;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for(int l=0,h=0;h<s.length();h++){
            if(h-l+1>=minSize){
                int z = h;
                while(z-l+1<=maxSize && z<s.length()){
                    String sub = s.substring(l,++z);
                    if(map.containsKey(sub) || count(sub)<=maxLetters){
                        map.put(sub, map.getOrDefault(sub,0)+1);
                        max = Math.max(max, map.get(sub));
                    }
                }
                l++;
            }
        }
        return max;
    }

    private int count(String s){
        int[] characters = new int[26];
        int count = 0;
        for(char c:s.toCharArray()){
            if(characters[c-'a'] == 0) count++;
            characters[c-'a']++;
        }
        return count;
    }

    public static void main(String[] args){

        MaximumNumberOfOccurrencesOfASubstring m = new MaximumNumberOfOccurrencesOfASubstring();
        System.out.println(m.maxFreq("aababcaab", 2,3,4));
        System.out.println(m.maxFreq2("aababcaab", 2,3,4));//

    }
}
