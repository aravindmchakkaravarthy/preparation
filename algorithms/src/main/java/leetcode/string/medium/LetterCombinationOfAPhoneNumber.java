package leetcode.string.medium;

import java.util.*;

public class LetterCombinationOfAPhoneNumber {

    public void helper(List<String> output, String nextDigits, String combination, String[] map){
        if(nextDigits.length() == 0){
            output.add(combination);
        }else{
            char c = nextDigits.charAt(0);
            for(char x: map[c - '0'].toCharArray()){
                helper(output, nextDigits.substring(1), combination + x, map);
            }
        }
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        String[] map = {"0","1", "abc", "def", "ghi","jkl","mno","pqrs", "tuv", "wxyz"};
        helper(result, digits, "", map);
        return result;
    }

    public List<String> letterCombinationsQueue(String digits){
        LinkedList<String> result = new LinkedList<>();
        if(digits.length() == 0) return result;
        String[] map = {"0","1", "abc", "def", "ghi","jkl","mno","pqrs", "tuv", "wxyz"};
        result.add("");
        while(result.peek().length() != digits.length()){
            String r = result.remove();
            String mapping = map[digits.charAt(r.length()) - '0'];
            for(char c: mapping.toCharArray()){
                result.add(r + c);
            }
        }
        return result;

    }

    public static void main(String[] args){
        LetterCombinationOfAPhoneNumber le = new LetterCombinationOfAPhoneNumber();
        System.out.println(le.letterCombinations("23"));
        System.out.println(le.letterCombinationsQueue("23"));
    }
}
