package leetcode.array.easy;

import util.PrintUtil;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SqauresOfASortedArray {

    public static int[] sortedSquares(int[] A) {
        int nI = -1, pI=-1;
        for(int x:A){
            if(x<0) {
                nI++;
            }else{
                pI=nI+1;
                break;
            }
        }
        int[] ans = new int[A.length];
        int index = 0;
        while(nI>=0 || (pI < A.length&& pI !=-1)){
            int nNo = nI >= 0 ? A[nI] * A[nI] : Integer.MAX_VALUE;
            int pNo = pI < A.length && pI !=-1 ? A[pI] * A[pI]:Integer.MAX_VALUE;
            if(nNo<=pNo){
                ans[index++] = nNo;
                nI--;
            }else{
                ans[index++] = pNo;
                pI++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {-1};
        int[] result = sortedSquares(nums);
        PrintUtil.print(result);
    }
}
