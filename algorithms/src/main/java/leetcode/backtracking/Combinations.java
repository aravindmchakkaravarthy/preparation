package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {

    private void helper(List<List<Integer>> result, List<Integer> combination, int n, int k, int start){
        if(combination.size() == k){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=start;i<=n;i++){
            combination.add(i);
            helper(result, combination, n, k, i+1);
            combination.remove(combination.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    public static void main(String[] args){
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(5,2));
    }
}
