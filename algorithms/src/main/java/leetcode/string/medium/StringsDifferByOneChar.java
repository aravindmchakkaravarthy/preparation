package leetcode.string.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings dict where all the strings are of the same length.
 *
 * Return True if there are 2 strings that only differ by 1 character in the same index, otherwise return False.
 *
 * Follow up: Could you solve this problem in O(n*m) where n is the length of dict and m is the length of each string.
 *
 *
 *
 * Example 1:
 *
 * Input: dict = ["abcd","acbd", "aacd"]
 * Output: true
 * Explanation: Strings "abcd" and "aacd" differ only by one character in the index 1.
 * Example 2:
 *
 * Input: dict = ["ab","cd","yz"]
 * Output: false
 * Example 3:
 *
 * Input: dict = ["abcd","cccc","abyd","abab"]
 * Output: true
 *
 *
 * Constraints:
 *
 * Number of characters in dict <= 10^5
 * dict[i].length == dict[j].length
 * dict[i] should be unique.
 * dict[i] contains only lowercase English letters.
 */
public class StringsDifferByOneChar {

    public boolean differByOne(String[] dict) {

        Set<String> set = new HashSet<>();
        for(String d:dict){
            for(int i=0;i<d.length();i++){

                String x = "";
                if(i==0){
                    x = d.substring(i+1);
                }else if(i==d.length()-1){
                    x = d.substring(0,i);
                }else{
                    x = d.substring(0,i)+d.substring(i+1);
                }
                if(!set.add(x)){
                    return true;
                }

            }
        }
        return false;

    }

    public boolean differByOneApproach2(String[] dict) {

        Set<String> set = new HashSet<String>();
        int len = dict[0].length();
        for(int i=0;i<len;i++){
            set.clear();
            for(String word:dict){
                String x = word.substring(0,i) + word.substring(i+1,len);
                if(set.contains(x)){
                    return true;
                }
                set.add(x);
            }
        }
        return false;

    }

    public static void main(String[] args){
        String[] input = {"abcd","acbd", "aacd"};
        StringsDifferByOneChar s = new StringsDifferByOneChar();
        System.out.println(s.differByOne(input));
        System.out.println(s.differByOneApproach2(input));
    }
}
