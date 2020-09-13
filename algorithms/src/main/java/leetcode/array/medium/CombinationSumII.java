package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {

    public void helper(List<Integer> combination, List<List<Integer>> result, int start, int target, int[] candidates){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i] == candidates[i-1]) continue;
            combination.add(candidates[i]);
            helper(combination, result, i+1, target-candidates[i], candidates);
            combination.remove(combination.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(new ArrayList<>(), result, 0, target, candidates);
        return result;
    }

    public static void main(String[] args){
        CombinationSumII cs = new CombinationSumII();
        int i = 0;
        char c = (char) ('a' + i);
        System.out.println(c);
        System.out.println(cs.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        // #backtracking
    }
}
