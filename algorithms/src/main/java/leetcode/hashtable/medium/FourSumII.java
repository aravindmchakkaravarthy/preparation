package leetcode.hashtable.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example:
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 */
public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> first = new HashMap<>();
        for(int x:A){
            for(int y:B){
                int sum = x+y;
                first.put(sum, first.getOrDefault(sum, 0)+1);
            }
        }
        int res = 0;
        for(int x:C){
            for(int y:D){
                int sum = x+y;
                res += first.getOrDefault(-1*sum, 0);
            }
        }
        return res;
    }

    public static void main(String[] args){


        System.out.println((float) (5 + 4) / 2);
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        FourSumII fourSumII = new FourSumII();
        System.out.println(fourSumII.fourSumCount(A, B, C, D));
    }
}
