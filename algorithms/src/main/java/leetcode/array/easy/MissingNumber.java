package leetcode.array.easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        if(nums.length > 1){
            int requiredSum = ((nums.length + 1)*(nums.length))/2;
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum += nums[i];
            }
            return requiredSum - sum;
        }
        return -1;


    }

    public static void main(String[] args){
        int[] nums = {0,1,2,3,4,5,7};
        System.out.print(missingNumber(nums));

    }
}
