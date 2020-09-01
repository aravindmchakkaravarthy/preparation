package leetcode.bst.easy;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class KthLargest {

    int k;
    PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for(int x:nums){
            add(x);
        }
    }

    public int add(int val) {
        heap.add(val);
        if(heap.size()>k){
            heap.poll();
        }
        if(heap.size()>0){
            return heap.peek();
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args){

        KthLargest k = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }
}
