package leetcode.stack.easy;

import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;

        for(String s:ops){
            switch (s){
                case "+":
                    int size = 0, first = 0, second = 0;
                    if(!stack.isEmpty()){
                        first  = stack.pop();
                        size++;
                    }
                    if(!stack.isEmpty()){
                        second = stack.pop();
                        size++;
                    }
                    sum += first + second;
                    if(size==2){
                        stack.push(second);
                        stack.push(first);
                    }else if (size == 1){
                        stack.push(first);
                    }
                    stack.push(first + second);
                    break;
                case "C":
                    sum -= stack.pop();
                    break;
                case "D":
                    sum += stack.peek() + stack.peek();
                    stack.push(stack.peek()*2);
                    break;
                default:
                    int value = Integer.parseInt(s);
                    sum+=value;
                    stack.push(value);
            }
        }
        return sum;

    }

    public static void main(String[] args){
        BaseballGame bg = new BaseballGame();
        System.out.println(bg.calPoints(new String[]{"5","2","C","D","+"}));
    }
}
