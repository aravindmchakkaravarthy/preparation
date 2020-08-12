package leetcode.array.easy;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Find the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 */
public class KthMissingPositiveNumber {

    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int count = 0;
        while(++start < arr[0]){
            if(++count == k){
                return start;
            }
        }
        int prev = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-prev >1){
                while(++prev < arr[i]){
                    if(++count == k){
                        return prev;
                    }
                }
            }
            prev = arr[i];
        }
        prev = arr[arr.length-1];
        while(count<k){
            prev++;
            count++;
        }
        return prev;

    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int k = 5;
        System.out.println(findKthPositive(nums, k));


    }
}
