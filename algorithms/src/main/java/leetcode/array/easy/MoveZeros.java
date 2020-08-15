package leetcode.array.easy;

import util.PrintUtil;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]a
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeros {

    public static void moveZeros(int[] nums) {
        int noOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                noOfZeros++;
            } else {
                if (noOfZeros != 0) {
                    nums[i - noOfZeros] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);
        PrintUtil.print(nums);
    }
}
