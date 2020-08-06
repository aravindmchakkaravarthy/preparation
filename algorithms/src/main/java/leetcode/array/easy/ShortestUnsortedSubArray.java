package leetcode.array.easy;

import java.util.Arrays;

public class ShortestUnsortedSubArray {

    public static int findUnsortedSubarray(int[] nums) {

        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = nums.length, end =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != snums[i]){
                start = Math.min(start,i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end-start+1:0);
    }

    public static int findUnsortedSubarrayApproach2(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args){

        //Approach 2 - is brute force o(n2) but space complexity is o(1)
        //Solution Time complexity o(n log n) but space complexity is o(1)
        int[] nums = {5,2,3,4,6};
        int[] nums2 = {5,4,3,2,1};
        int[] nums3 = {1,3,2,2,2};
        int[] nums4 = {1,4,3,5,6,7};
        int[] nums5 = {1,4,3,5,4,6};
        int[] nums6 = {1,8,4,5,6,7};
        int[] nums7 = {1,2,3,5,7};
        int[] nums8 = {2,3,3,2,4};

        System.out.println(findUnsortedSubarray(nums));//4
        System.out.println(findUnsortedSubarrayApproach2(nums2));//5
        System.out.println(findUnsortedSubarray(nums3));//4
        System.out.println(findUnsortedSubarray(nums4));//2
        System.out.println(findUnsortedSubarrayApproach2(nums5));//4
        System.out.println(findUnsortedSubarray(nums6));//5
        System.out.println(findUnsortedSubarrayApproach2(nums7));//0
        System.out.println(findUnsortedSubarray(nums8));//3
    }
}
