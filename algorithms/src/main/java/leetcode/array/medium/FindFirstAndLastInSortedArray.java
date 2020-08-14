package leetcode.array.medium;

import leetcode.array.easy.PrintUtil;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m] == target){
                int lo = m, hi = m;
                while(lo>0 && nums[lo-1] == target)lo--;
                while(hi<nums.length-1 && nums[hi+1] == target)hi++;
                return new int[]{lo,hi};
            }else if(nums[m]<target){
                l = m +1;
            }else {
                r = m -1;
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args){
        int[] nums = {5,7,8,8,8,8,8,8,8,8,8,10};
        int[] nums1 = {5,7,7,8,8,10};

        PrintUtil.print(searchRange(nums, 8));
        PrintUtil.print(searchRange(nums1, 8));
        PrintUtil.print(searchRange(nums1, 7));
        PrintUtil.print(searchRange(nums1, 5));
        PrintUtil.print(searchRange(nums1, 10));
    }
}
