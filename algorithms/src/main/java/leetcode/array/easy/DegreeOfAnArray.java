package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 */
public class DegreeOfAnArray {


    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0;i<nums.length; i++){
            if(!left.containsKey(nums[i])){
                left.put(nums[i], i);
            }
            right.put(nums[i],i);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        int ans = nums.length;
        int degree = 0;
        for(int n:count.keySet()){
            if(count.get(n) > degree){
                degree = count.get(n);
                ans = right.get(n)-left.get(n)+1;
            }
            else if(count.get(n) ==degree){
                ans = Math.min(right.get(n)-left.get(n)+1, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1,2,2,3,1,4,2};
        System.out.print(findShortestSubArray(nums));
    }
}
