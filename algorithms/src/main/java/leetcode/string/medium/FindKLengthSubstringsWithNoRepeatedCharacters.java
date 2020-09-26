package leetcode.string.medium;

/**
 * Given a string S, return the number of substrings of length K with no repeated characters.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "havefunonleetcode", K = 5
 * Output: 6
 * Explanation:
 * There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
 * Example 2:
 *
 * Input: S = "home", K = 5
 * Output: 0
 * Explanation:
 * Notice K can be larger than the length of S. In this case is not possible to find any substring.
 *
 *
 * Note:
 *
 * 1 <= S.length <= 10^4
 * All characters of S are lowercase English letters.
 * 1 <= K <= 10^4
 */
public class FindKLengthSubstringsWithNoRepeatedCharacters {

    public int numKLenSubstrNoRepeats(String S, int K) {

        int[] chars = new int[26];
        int result = 0;
        for(int l=0,i=0;i<S.length();i++){
            while(chars[S.charAt(i)-'a'] > 0){
                chars[S.charAt(l++)-'a']--;
            }
            chars[S.charAt(i) - 'a']++;
            if(i-l==K-1){
                result++;
                chars[S.charAt(l++)-'a']--;
            }
        }
        return result;

    }

    public static void main(String[] args){
        FindKLengthSubstringsWithNoRepeatedCharacters f = new FindKLengthSubstringsWithNoRepeatedCharacters();
        System.out.println(f.numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }


}
