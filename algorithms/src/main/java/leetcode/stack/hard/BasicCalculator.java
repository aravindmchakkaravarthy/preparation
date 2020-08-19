package leetcode.stack.hard;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {

        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            String str = String.valueOf(s.charAt(i));
            if(str.matches("[0-9]")){
                StringBuilder sb = new StringBuilder(str);
                while(i+1 < s.length() && String.valueOf(s.charAt(i+1)).matches("[0-9]")){
                    sb.append(s.charAt(++i));
                }
                str = sb.toString();
            }

            if(str.equals(" "))continue;
            if(!str.equals(")")){
                stack.push(str);
            }else{
                boolean matchFound = false;
                int sign = 1;
                int prev = 0;
                while(!matchFound && !stack.isEmpty()){
                    String valStr = stack.pop();
                    switch (valStr){
                        case "(":
                            matchFound = true;
                            break;
                        case "+":
                            sign = 1;
                            break;
                        case "-":
                            sign = 0;
                            break;
                        default:
                            prev = sign == 1 ? prev + Integer.parseInt(valStr) : Integer.parseInt(valStr) - prev;
                    }
                }
                stack.push(String.valueOf(prev));
            }
        }
        int res = 0;

        while(!stack.isEmpty()){

            String valStr = stack.pop();
            if(valStr.equals("-") || valStr.equals("+")){
                continue;
            }
            if(stack.empty()){
                res += Integer.parseInt(valStr);
                continue;
            }
            if(stack.peek().equals("+")){
                res += Integer.parseInt(valStr);
            }else{
                res -= Integer.parseInt(valStr);
            }
        }
        return res;

    }

    public static void main(String[] args){
        Set<Character> set = new HashSet<>();

        String s = "abc";
        set.add(s.charAt(2));
        System.out.println(set.contains(s.charAt(2)));
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
        System.out.println(basicCalculator.calculate("22+22"));
    }


}
