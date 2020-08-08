package leetcode.array.easy;

import java.sql.SQLOutput;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 */
public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {

        int replaceCount = 0;
        int prev = nums[0];
        if (nums.length <= 1) {
            return true;
        }
        if (nums[0] > nums[1]) {
            nums[0] = nums[1] - 1;
            replaceCount++;
            prev = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                nums[i] = prev + 1;
                replaceCount++;
            }else if(i<nums.length-1 && nums[i] > nums[i+1] && !(nums[i+1] < prev)){
                nums[i] = nums[i+1];
                replaceCount++;
            }
            if (replaceCount > 1) {
                return false;
            }
            prev = nums[i];
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums = {4,2,1};
        System.out.println(checkPossibility(nums));
    }
}
