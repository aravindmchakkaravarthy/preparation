package leetcode.stack.medium;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class CustomStack {

    private Stack<Integer> stack;
    int size;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        size = maxSize;

    }

    public void push(int x) {
        if(stack.size()<size){
            stack.push(x);
        }
    }

    public int pop() {
        if(stack.size()>0){
            return stack.pop();
        }
        return -1;
    }

    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            if(stack.size()<=k){
                int x = val + stack.pop();
                temp.push(x);
            }else{
                temp.push(stack.pop());
            }
        }
        while(!temp.isEmpty()) stack.push(temp.pop());
    }

    public static void main(String[] args){
        CustomStack cs = new CustomStack(3);
        cs.push(1);
        cs.push(2);
        System.out.println(cs.pop());
        cs.push(2);
        cs.push(3);
        cs.push(4);
        cs.increment(5,100);
        cs.increment(2,100);
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
    }
}
