package leetcode.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    private boolean helper(int n, Set<Integer> set){
        if(set.contains(n)){
            return false;
        }
        if(n == 1){
            return true;
        }
        set.add(n);
        return helper(sumOfDigits(n), set);
    }

    public boolean isHappy(int n) {
        return helper(n, new HashSet<>());
    }

    private int sumOfDigits(int n){
        int sum = 0;
        while(n > 0) {
            int mod = n % 10;
            sum = sum + mod * mod;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappyApproach2(int n){
        int slow = n, fast = sumOfDigits(n);
        while(slow != fast){
            slow = sumOfDigits(slow);
            fast = sumOfDigits(sumOfDigits(fast));
            if(fast == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(19));
        System.out.println(hn.isHappy(20));

        System.out.println(hn.isHappyApproach2(19));
        System.out.println(hn.isHappyApproach2(20));
    }
}
