package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {

    private void backTrack(LinkedList<Integer> list, int start, List<List<Integer>> result, int[] candidates, int target){
        if(target<0){
            return;
        }else if (target==0){
            result.add(new ArrayList<Integer>(list));
        }else{
            for(int i=start;i<candidates.length;i++){
                list.add(candidates[i]);
                backTrack(list, i, result, candidates, target-candidates[i]);
                list.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(new LinkedList<>(), 0, result, candidates, target);
        return result;

    }

    private void helper(List<Integer> list, List<List<Integer>> result, int[] candidates, int sum, int target){
        if(sum > target){
            return;
        }else if (sum == target){
            Collections.sort(list);
            if(!result.contains(list)){
                result.add(list);
            }
        }else{
            for(int c:candidates){
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(c);
                helper(newList, result, candidates, sum + c, target);
            }
        }
    }

    public List<List<Integer>> combinationSumApproach1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<>(), result, candidates, 0, target);
        return result;

    }


    public static void main(String[] args){
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSumApproach1(new int[]{2,3,6,7}, 7)); // TODO - came up with own solution.
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7)); // TODO - below is backtracking solution
        // #backtracking
    }
}
