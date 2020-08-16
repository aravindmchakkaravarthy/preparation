package leetcode.stack.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        List<String> pushPopList = new ArrayList<>();
        int current = 1;
        for(int x:target){
            while(current<x){
                pushPopList.add("Push");
                pushPopList.add("Pop");
                current++;
            }
            pushPopList.add("Push");
            current++;
        }
        return pushPopList;
    }

    public List<String> buildArrayUsingStack(int[] target, int n){
        int t = 0, i=0;
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        while(t<target.length){
            stack.push(++i);
            list.add("Push");
            if(stack.peek() == target[t]){
                t++;
            }else{
                stack.pop();
                list.add("Pop");
            }
        }
        return list;
    }

    public static void main(String[] args){
        BuildArrayWithStackOperations buildArrayWithStackOperations = new BuildArrayWithStackOperations();
        System.out.println(buildArrayWithStackOperations.buildArray(new int[]{1,3}, 3));
        System.out.println(buildArrayWithStackOperations.buildArrayUsingStack(new int[]{1,3}, 3));
    }
}
