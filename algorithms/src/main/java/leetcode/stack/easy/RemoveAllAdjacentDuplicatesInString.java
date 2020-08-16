package leetcode.stack.easy;

import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 *
 * Note:
 *
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=S.length()-1;i>=0;i--){
            char c = S.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();

    }

    public static void main(String[] args){
        RemoveAllAdjacentDuplicatesInString raadis = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(raadis.removeDuplicates("abbaca"));
    }
}
