package leetcode.array.easy;

import util.PrintUtil;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 */
public class UniqueDigitsSumToZero {
    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        for(int i=1;i<n;i++){
            ans[i-1] = -i;
        }

        ans[n-1] = n*(n-1) / 2;
        return ans;
    }

    public static void main(String[] args){

        int[] nums = sumZero(5);
        PrintUtil.print(nums);
    }


}
