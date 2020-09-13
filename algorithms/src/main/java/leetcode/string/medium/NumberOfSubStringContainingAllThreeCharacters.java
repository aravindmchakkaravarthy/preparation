package leetcode.string.medium;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class NumberOfSubStringContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int[] last = {-1,-1,-1}; int result = 0;
        for(int i=0;i<s.length();i++){
            last[s.charAt(i)-'a'] = i;
            result += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }
        return result;

    }

    public static void main(String[] args){
        NumberOfSubStringContainingAllThreeCharacters n = new NumberOfSubStringContainingAllThreeCharacters();
        System.out.println(n.numberOfSubstrings("abcabc"));
    }
}
