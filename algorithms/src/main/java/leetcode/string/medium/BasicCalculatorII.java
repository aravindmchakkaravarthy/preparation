package leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculatorII {



    public int calculate(String s) {
        char[] string = s.trim().toCharArray();
        int preVal = 0, res = 0, curVal = 0, i= 0, length = string.length;
        char sign = '+';
        while(i<length){
            if(string[i] == ' ') {
                i++;
                continue;
            }
            curVal = 0;
            while(i<length && Character.isDigit(string[i])){
                curVal = curVal * 10 +  (string[i] - '0');
                i++;
            }
            switch (sign){
                case '+':
                    res += preVal;
                    preVal = curVal;
                    break;
                case '-':
                    res += preVal;
                    preVal = -curVal;
                    break;
                case '*':
                    preVal *= curVal;
                    break;
                case '/':
                    preVal /= curVal;
                    break;
            }
            if(i<length){
                sign = string[i++];
            }
        }
        return res + preVal;
    }

    public static void main(String[] args){

        BasicCalculatorII calc = new BasicCalculatorII();
        System.out.println(calc.calculate(" 3/2 "));
    }
}
