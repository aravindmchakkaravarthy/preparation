package leetcode.stack.easy;

import java.util.Stack;
import java.util.prefs.BackingStoreException;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 */
public class BackSpaceStringCompare {

    private Stack<String> getStack(String S){
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '#'){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(String.valueOf(S.charAt(i)));
            }

        }
        return stack;
    }

    private String getString(Stack<String> s){
        StringBuffer sb = new StringBuffer();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<String> fS = getStack(S);
        Stack<String> sS = getStack(T);
        String firstString = getString(fS);
        String secondString = getString(sS);
        return firstString.equals(secondString);
    }

    public static void main(String[] args){
        BackSpaceStringCompare bssc = new BackSpaceStringCompare();
        System.out.println(bssc.backspaceCompare( "ab##", "c#d#"));
    }
}
