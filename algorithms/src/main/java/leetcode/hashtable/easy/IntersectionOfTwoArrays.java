package leetcode.hashtable.easy;

import util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {



    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for(int x:nums1){
            set.add(x);
        }

        Set<Integer> result = new HashSet<>();
        for(int y:nums2){
            if(set.contains(y)){
                result.add(y);
            }
        }

        int[] x = new int[result.size()];
        int i = 0;
        for(int z:result){
            x[i++] = z;
        }

        return x;

    }

    public static void main(String[] args){
        int[] nums1 = {1,2,2,3,4};
        int[] nums2 = {2,2,2,4,1,1};
        IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();
        PrintUtil.print(iota.intersection(nums1, nums2));

        System.out.println('Z' - '9');
    }
}
