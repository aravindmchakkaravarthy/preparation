package leetcode.array.easy;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOne {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int currentCount = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                currentCount++;
            }
            if(nums[i] == 0){
                if(currentCount>result){
                    result=currentCount;
                }
                currentCount=0;
            }
        }
        if(currentCount > result) result = currentCount;
        return result;
    }

    public static void main(String args[]){
        int[] nums = {1,1,0,1,1,1};
        System.out.print(findMaxConsecutiveOnes(nums));
    }
}
