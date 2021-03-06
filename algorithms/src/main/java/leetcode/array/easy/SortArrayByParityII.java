package leetcode.array.easy;

import util.PrintUtil;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */
public class SortArrayByParityII {

    public static int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for(int i=0;i<A.length;i+=2){
            if(A[i]%2 == 1){
                while(A[j] % 2 == 1){
                    j = j +1;
                }
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args){
        int[] result = sortArrayByParityII(new int[]{4,2,5,7});
        PrintUtil.print(result);

    }
}
