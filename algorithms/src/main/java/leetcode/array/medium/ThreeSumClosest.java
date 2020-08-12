package leetcode.array.medium;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentTarget = -1;
        for(int i=0;i<nums.length-2;i++){
            int l= i+1;
            int r= nums.length-1;
            while(l<r){
                int newTarget = nums[i] + nums[l] + nums[r];
                if ((i==0 && l==1 && r==nums.length-1) || Math.abs(target - newTarget) < Math.abs(target - currentTarget)){
                    currentTarget = newTarget;
                }
                if(newTarget<=target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return currentTarget;

    }

    public static void main(String[] args){

        System.out.println(threeSumClosest(new int[]{1,1,-1,-1,3}, -1));

    }
}
