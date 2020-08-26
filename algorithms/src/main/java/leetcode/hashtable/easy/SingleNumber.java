package leetcode.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumOfNums = 0, sumOfSet =0;
        for(int x:nums){
            if(!set.contains(x)){
                sumOfSet += x;
                set.add(x);
            }
            sumOfNums +=x;
        }
        return 2 * sumOfSet - sumOfNums;
    }

    public static void main(String[] args){
        int[] nums = {2,2,1};
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(nums));
    }


}
