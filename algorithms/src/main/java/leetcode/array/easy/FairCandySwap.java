package leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 *
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 *
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 *
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 *
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 *
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 */
public class FairCandySwap {

    public static int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0,totalB=0;
        for(int x:A) totalA += x;
        for(int x:B) totalB += x;
        Set<Integer> BNos = new HashSet<>();
        int delta = (totalB - totalA)/2;
        for(int x:B) BNos.add(x);
        for(int x:A){
            if(BNos.contains(x+delta)){
                return new int[]{x, x+delta};
            }
        }
        throw null;
    }


    public static void main(String[] args){
        int[] A = {1,3}; int[] B = {2,1};
        int[] result = fairCandySwap(A, B);
        PrintUtil.print(result);
    }
}
