package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    private void helper(List<List<Integer>> result, List<Integer> permutation, int[] nums){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(permutation.contains(nums[i])) continue;
            permutation.add(nums[i]);
            helper(result, permutation, nums);
            permutation.remove(permutation.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(),nums);
        return result;
    }

    public static void main(String[] args){
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1,2,3}));

    }
}
