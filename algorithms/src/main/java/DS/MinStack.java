package DS;

import java.util.ArrayList;
import java.util.List;

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
