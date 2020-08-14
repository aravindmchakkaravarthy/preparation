package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static List<List<Integer>> twoSum(int[] nums, int start, int target){
        List<List<Integer>> list = new ArrayList<>();
        int l = start;
        int r = nums.length-1;
        while(l<r){
            int sum = nums[l] + nums[r];
            if(sum<target || (l>0 && nums[l] == nums[l-1])){
                l++;
            }else if(sum>target || (r<nums.length-1 && nums[r] == nums[r+1])){
                r--;
            }else{
                list.add(Arrays.asList(nums[l++], nums[r--]));
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1])continue;
            List<List<Integer>> res = twoSum(nums, i+1, target - nums[i]);
            for(List<Integer> r:res){
                List<Integer> set = new ArrayList<>();
                set.add(nums[i]);
                set.addAll(r);
                list.add(set);
            }

        }
        return list;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
