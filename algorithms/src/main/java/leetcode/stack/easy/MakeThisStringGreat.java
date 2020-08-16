package leetcode.stack.easy;

import java.util.Stack;

public class MakeThisStringGreat {
    public String makeGood(String s) {
        Stack<String> stack = new Stack<String>();
        for(int i=s.length()-1;i>=0;i--){
            String thisChar = String.valueOf(s.charAt(i));
            if(!stack.isEmpty()){
                String sElement = stack.peek();
                if(!sElement.equals(thisChar) && sElement.toUpperCase().equals(thisChar.toUpperCase())){
                    stack.pop();
                }else{
                    stack.push(thisChar);
                }
            }else{
                stack.push(thisChar);
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args){
        MakeThisStringGreat mtsg = new MakeThisStringGreat();
        System.out.println(mtsg.makeGood("leEeetcode"));

    }
}
