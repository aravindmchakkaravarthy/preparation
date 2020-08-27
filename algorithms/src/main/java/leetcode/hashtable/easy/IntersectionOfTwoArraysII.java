package leetcode.hashtable.easy;

import util.PrintUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        count1.values();
        for(int x:nums1){
            count1.put(x, count1.getOrDefault(x, 0)+1);
        }

        for(int x:nums2){
            count2.put(x, count2.getOrDefault(x, 0)+1);
        }
        int[] result = new int[nums1.length+nums2.length];
        int count=0;
        for(int x: count1.keySet()){
            int times = Math.min(count1.get(x), count2.getOrDefault(x, 0));
            while(times > 0){
                result[count++] = x;
                times--;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        IntersectionOfTwoArraysII in = new IntersectionOfTwoArraysII();
        PrintUtil.print(in.intersect(nums1, nums2));

        System.out.println((int)'a');
    }


}
