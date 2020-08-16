package leetcode.stack.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidString {

    public Character getMatchingEnd(Character c){
        switch (c){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:return null;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> beginning = new HashSet<>(Arrays.asList('(','{','['));
        Set<Character> end = new HashSet<>(Arrays.asList(')','}',']'));
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            if(beginning.contains(c)){
                stack.push(c);
            }else if(end.contains(c)){
                Character target = getMatchingEnd(c);
                if(stack.isEmpty() || !target.equals(stack.pop())){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidString vs = new ValidString();
        System.out.println(vs.isValid("(]"));
    }
}
