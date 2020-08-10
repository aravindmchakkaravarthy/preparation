package leetcode.array.easy;

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 *
 * Example 1:
 *
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 *
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 */
public class FindNumberWEvenDigits {

    public static int findNumbers(int[] nums) {
        int countOfEven = 0;
        for(int x:nums){
            int countOfDigits = 1;
            int multiple = 10;
            while(multiple < x){
                multiple *= 10;
                countOfDigits++;
            }
            if(multiple == x){
                countOfDigits++;
            }
            if(countOfDigits % 2 ==0){
                countOfEven++;
            }
        }
        return countOfEven;
    }

    public static void main(String[] args){
        int[] nums = {100000};
        System.out.println(findNumbers(nums));
    }
}
