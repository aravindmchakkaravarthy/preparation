package leetcode.string.easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int[] kmp = process(s);
        int len = kmp[s.length()-1];
        int n = s.length();
        return (len > 0 && (n % (n-len) == 0));

    }

    private int[] process(String s){
        int[] kmp = new int[s.length()];
        int i = 0,j=1;
        while(j<s.length()){
            if(s.charAt(i) == s.charAt(j)){
                kmp[j] = i + 1;
                i++; j++;
            }else if (i>0){
                i = kmp[i-1];
            }else{
                j++;
            }
        }
        return kmp;
    }

    public static void main(String[] args){
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();
        System.out.println(r.repeatedSubstringPattern("abcabc"));
    }
}
