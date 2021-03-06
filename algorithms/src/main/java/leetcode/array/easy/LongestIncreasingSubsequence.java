package leetcode.array.easy;

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 */
public class LongestIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int currentCount = 1;
        int maxCount = 1;
        int prev = nums[0];
        for (int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                currentCount++;
            }else{
                currentCount = 1;
            }
            if(currentCount > maxCount){
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    public static void main(String args[]){
        int[] nums = {1,2,3,5,1};
        System.out.print(findLengthOfLCIS(nums));
    }
}
