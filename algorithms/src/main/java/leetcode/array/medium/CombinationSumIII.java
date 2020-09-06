package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {

    private void helper(List<List<Integer>> result, List<Integer> subset, int start, int k, int n){

        if(subset.size() == k && n ==0){
            result.add(new ArrayList<>(subset));
            return;
        }
        if(subset.size()==k || n<0){
            return;
        }

        for(int i=start;i<=9;i++){
            subset.add(i);
            helper(result, subset, i+1, k, n-i);
            subset.remove(subset.size()-1);
        }

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    public static void main(String[] args){
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3,9));
    }
}
