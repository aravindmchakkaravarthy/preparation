package leetcode.array.easy;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

/**
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 *
 * More formally check if there exists two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * Example 1:
 *
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 *
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * Example 3:
 *
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 */
public class CheckIfNAndItsDoubleExist {

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int x:arr) {
            if(set.contains(2*x) || (x%2==0)&& set.contains(x/2)) {
                return true;
            }

            set.add(x);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {10,2,5,3};
        System.out.println(checkIfExist(nums));
    }
}
