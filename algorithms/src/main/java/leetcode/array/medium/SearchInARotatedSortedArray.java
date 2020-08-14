package leetcode.array.medium;

import java.util.Arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInARotatedSortedArray {



    public static int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;

        //find pivot
        int low = 0, high = nums.length-1, mid = (low+high)/2;
        while(true){
            mid = (low+high)/2;
            if(low == mid || mid == high)//pivot found
                break;
            if(nums[mid] < nums[high])//pivot on the left
                high = mid;
            else//pivot on the right
                low = mid;
        }
        //high is the minimum # in the array
        int index = Math.max(Arrays.binarySearch(nums, 0, high, target),
                Arrays.binarySearch(nums, high, nums.length, target));
        return index >= 0 ? index : -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        //TODO this solution was copied from discussion. need to analyze or implement own solution
        System.out.println(search(new int[]{0, 1, 2, 3, 4}, 0));//expects 0
        System.out.println(search(new int[]{4, 1, 2, 3, 4}, 10));
        ;//expects -1
        System.out.println(search(new int[]{4, 1, 2, 3, 4}, 0));
        ;//expects -1
        System.out.println(search(new int[]{9, 0, 1, 2, 3, 4, 5, 6, 7}, 4));//expects 6
        System.out.println(search(new int[]{8, 9, 0, 1, 2, 3, 4, 5, 6, 7}, 4));//expects 7
        System.out.println(search(new int[]{8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7}, 4));//expects 7
        System.out.println(search(new int[]{9}, 9));//expects 0
        System.out.println(search(new int[]{9}, 8));//expects -1
        System.out.println(search(new int[]{5, 6, 7, 8, 9, 10, 11, 1}, 10));//expects 5
        System.out.println(search(nums, 4));//expects -1
    }

}
