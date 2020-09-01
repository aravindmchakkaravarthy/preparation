package leetcode.hashtable.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringwithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        int max = 0;
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.containsKey(ch) && map.get(ch) >=start) {
                max = Math.max(length, max);
                length = i - map.get(ch) - 1;
                start = map.get(ch) + 1;
            }
            map.put(ch, i);
            length++;

        }
        return Math.max(length, max);


    }

    public static void main(String[] args){
        LongestSubstringwithoutRepeatingCharacters ls = new LongestSubstringwithoutRepeatingCharacters();
        System.out.println(ls.lengthOfLongestSubstring("abba"));
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstring("bbbb"));
        System.out.println(ls.lengthOfLongestSubstring("ababababa"));
    }

}
