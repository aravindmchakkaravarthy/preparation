package leetcode.stack.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 */
public class MinStack {

    List<Integer> data;

    MinStack(){
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        data.remove(data.size()-1);
    }

    public int top() {
        if(data.size()>0){
            return data.get(data.size()-1);
        }
        return -1;
    }

    public int getMin() {
        int temp = Integer.MAX_VALUE;
        for(int x:data){
            if(x<temp) temp = x;
        }
        return temp;
    }

    public static void main(String[] args){


        MinStack obj = new MinStack();
         obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
         obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
