package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {

    private void helper(String s, int n, int open, int close, List<String> result){
        if(s.length() == 2 * n){
            result.add(s);
            return;
        }
        if(open < n){
            helper(s+"(", n, open+1, close, result);
        }
        if(close < open){
            helper(s+")", n, open, close+1, result);
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("", n, 0, 0, result);
        return result;
    }

    public static void main(String[] args){
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3));
    }


}
