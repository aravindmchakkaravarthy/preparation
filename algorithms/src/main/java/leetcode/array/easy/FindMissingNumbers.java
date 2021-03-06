package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindMissingNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> x = new ArrayList<>();
        Arrays.sort(nums);
        int index = 1;
        for(int i=0;i<nums.length;i++){
            while(nums[i] - index > 0){
                x.add(index++);
            }
           if(nums[i] == index){
                index++;
            }
        }
        while(index <nums.length+1){
            x.add(index++);
        }
        return x;
    }

    public static void main(String args[]){
        int[] nums = {1,1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.print(result);
    }
}
