package leetcode.array.easy;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {
        long first = nums[0], second = Integer.MIN_VALUE-1L, third = Integer.MIN_VALUE-1L;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != first && nums[i] != second && nums[i] != third){
                if(nums[i] > first){
                    third=second;
                    second=first;
                    first=nums[i];
                }else if(nums[i] > second){
                    third=second;
                    second=nums[i];
                }else if(nums[i] > third){
                    third = nums[i];
                }
            }

        }
        if(third != Integer.MIN_VALUE-1L) return (int) third;
        return (int) first;
    }

    public static void main(String[] args){
        int[] nums = {1,2,-2147483648};
        //int[] nums = {3,2,1};
        //int[] nums = {1,2};
        //int[] nums = {1};
        //int[] nums = {2,2,3,1};
        //int[] nums = {1,1,2};
        System.out.print(thirdMax(nums));
    }
}
