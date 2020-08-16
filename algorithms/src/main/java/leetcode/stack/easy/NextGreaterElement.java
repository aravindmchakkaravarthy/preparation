package leetcode.stack.easy;

import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0) return new int[0];
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        stack.push(nums2[nums2.length-1]);
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                map.put(nums2[i], stack.peek());
            }else{
                map.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args){
        NextGreaterElement nge = new NextGreaterElement();
        int[] result = nge.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
        PrintUtil.print(result);

    }
}
