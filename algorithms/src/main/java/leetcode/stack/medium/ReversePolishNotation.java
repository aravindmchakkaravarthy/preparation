package leetcode.stack.medium;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        for (String token : tokens) {
            int value = 0;
            switch (token) {
                case "+":
                    value = stack.pop() + stack.pop();
                    break;
                case "*":
                    value = stack.pop() * stack.pop();
                    break;
                case "/":
                    temp = stack.pop();
                    value = stack.pop() / temp;
                    break;
                case "-":
                    temp = stack.pop();
                    value = stack.pop() - temp;
                    break;
                default:
                    value = Integer.parseInt(token);
            }
            stack.push(value);
        }
        return stack.pop();
    }

    public static void main(String[] args){
        System.out.println(6/-132);
        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println(rpn.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }


}

