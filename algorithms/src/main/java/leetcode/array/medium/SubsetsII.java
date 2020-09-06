package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {

    private void helper(List<Integer> subset, List<List<Integer>> result, int start, int[] nums){
        result.add(new ArrayList<>(subset));
        for(int i = start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            helper(subset, result, i+1, nums);
            subset.remove(subset.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<>(), result, 0, nums);
        return result;
    }

    public static void main(String[] args){
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(new int[]{1,2,2}));

    }
}
