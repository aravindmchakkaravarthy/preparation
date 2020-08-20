package leetcode.stack.hard;

import java.util.*;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */

public class BasicCalculator {

    final List<String> LIST_OF_OPERATORS = Arrays.asList("+","-","*", "/");
    final String BEGIN_PARENTHESIS = "(";
    final String END_PARENTHESIS = ")";
    final String EMPTY_CHARACTER = " ";

    private int calculateApproach2(String s){
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }

    private int evaluate(Stack<Integer> operands, String operation){

        if(operation.equals("+")){
            return operands.pop() + operands.pop();
        }else {
            int r = operands.pop();
            return (operands.isEmpty()) ? 0 : operands.pop() - r;
        }
    }

    private void evaluateParanthesis(Stack<Integer> operands, Stack<String> operators){//Guaranteed to have a (
        int sum = 0;
        if(operators.peek().equals(BEGIN_PARENTHESIS)){
            sum = operands.pop();
        }
        while(!operators.isEmpty()){
            String operator = operators.pop();
            if(operator.equals("+")){
                sum += operands.pop() + operands.pop();
            }else if(operator.equals("-")){
                int r = operands.pop();
                sum += (operands.isEmpty()) ? 0 : operands.pop() - r;
            }else{
                break;
            }
        }
        operands.push(sum);
    }

    public int calculate(String s) {
        Stack<String> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        for(int i=0;i<s.length();i++){
            String c = String.valueOf(s.charAt(i));
            if(!c.equals(EMPTY_CHARACTER)){
                if(LIST_OF_OPERATORS.contains(c)){
                    if(!operators.isEmpty() && LIST_OF_OPERATORS.contains(operators.peek())){
                        operands.push(evaluate(operands, operators.pop()));
                    }
                    operators.push(c);
                }else if(c.equals(BEGIN_PARENTHESIS)){
                    operators.push(c);
                }else if (c.equals(END_PARENTHESIS)){
                    evaluateParanthesis(operands, operators);
                }else{
                    StringBuilder sb = new StringBuilder(c);
                    while(i < s.length()-1){
                        String next = String.valueOf(s.charAt(i+1));
                        if(next.matches("[0-9]")){
                            sb.append(next);
                        }else{
                            break;
                        }
                        i++;
                    }
                    operands.push(Integer.valueOf(sb.toString()));
                }
            }
        }
        return operators.isEmpty() ? operands.pop() : evaluate(operands, operators.pop());
    }

    public static void main(String[] args){
        Set<Character> set = new HashSet<>();
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate("22+22+22"));
        System.out.println(basicCalculator.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
    }


}
