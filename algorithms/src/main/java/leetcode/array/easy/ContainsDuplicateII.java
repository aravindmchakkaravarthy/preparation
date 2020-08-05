package leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicateApproach2(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        for(int j=0;j<nums.length;j++){
            if(!set.add(nums[j])){
                return true;
            }
            if(set.size() >= k+1){
                set.remove(nums[i++]);
            }
        }
        return false;

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                if(i - j <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }



    public static void main(String args[]){
        int[] test = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(test, 3));
        System.out.println(containsNearbyDuplicate(test, 3)); // Approach 2 - using hashset. only storing upto k elements.
    }
}
