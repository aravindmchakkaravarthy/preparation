package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    private void helper(List<Integer> subset, List<List<Integer>> result, int start, int[] nums){
        result.add(new ArrayList<>(subset));
        for(int i=start;i<nums.length;i++){
            subset.add(nums[i]);
            helper(subset, result, i+1, nums);
            subset.remove(subset.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<Integer>(), result, 0, nums);
        return result;
    }

    public static void main(String[] args){
        // #backtracking
        Subsets sb = new Subsets();
        System.out.println(sb.subsets(new int[]{1,2,3}));
    }


}
