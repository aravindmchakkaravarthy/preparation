package leetcode.array.easy;

import util.PrintUtil;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int i =0 , j = numbers.length-1;
        while(i<j){
            int x = numbers[i] + numbers[j];
            if(x == target){
                return new int[]{i+1,j+1};
            }
            if(x > target){
                j--;
            }else{
                i++;
            }
        }
        throw new IllegalArgumentException("No sum found");
    }

    public static void main(String args[]){
        int[] nums={2,7,11,15};
        PrintUtil.print(twoSum(nums, 18));
    }
}
