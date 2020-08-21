package leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
 *
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * Example 2:
 *
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * Example 3:
 *
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 *
 *
 * Constraints:
 *
 * 2 <= S.length <= 100
 * S will only contain lowercase letters and digits 2 through 9.
 * S starts with a letter.
 * 1 <= K <= 10^9
 * It's guaranteed that K is less than or equal to the length of the decoded string.
 * The decoded string is guaranteed to have less than 2^63 letters.
 */
public class DecodeStringAtIndex {

    public String decodeAtIndex(String S, int K) {
        String[] split = S.split("[0-9]");
        String[] nos = S.split("[a-z]+");
        List<Integer> digits = new ArrayList<Integer>();
        for(String n:nos){
            for (char c: n.toCharArray()){
                digits.add(c-'0');
            }
        }
        int i=0;
        String prev = "";
        for(int n:digits){
            if(i<split.length){
                prev += split[i++];
            }
            int times = 0;
            StringBuilder sb = new StringBuilder();
            while(times<n){
                sb.append(prev);
                times++;
            }
            prev = sb.toString();
            if(prev.length() >= K){
                return prev.substring(K-1,K);
            }
        }
        return "";
    }

    public static void main(String[] args){
        String s = "a2345678999999999999999";
        String[] nos = s.split("[a-z]+");
        for(String x:nos){
            System.out.println(x);
        }
        DecodeStringAtIndex ds = new DecodeStringAtIndex();
        System.out.println(ds.decodeAtIndex(s, 5));
    }
}