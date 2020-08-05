package leetcode.array.easy;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */

public class RotateArray {



    public static void rotateApproach2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            a[(i+k) % nums.length] = nums[i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = a[i];
        }
    }

    public static void rotate(int[] nums){
        int[] test = new int[]{0,1,2,3,4};
        int temp = nums[nums.length-1];
        if(nums.length>1){
            for(int i=nums.length-2;i>=0;i--){
                nums[i+1] = nums[i];
            }
        }
        nums[0] = temp;
        PrintUtil.print(nums);
    }

    public static void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++){
            rotate(nums);
        }

    }

    public static void rotateApproach3(int[] nums, int k){
        k = k % nums.length;
        int count = 0;
        for (int start=0;count<nums.length;start++){
            int current = start;
            int previous = nums[start];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = previous;
                previous = temp;
                current = next;
                count++;
            }while(start!=current);
        }
    }

    public static void main(String args[]){
        int[] test = new int[]{0,1,2,3,4};
        //rotate(test, 3);//Brute force
        //rotateApproach2(test, 3); //Time complexity: O(n) Space complexity: O(n)
        rotateApproach3(test, 3); //Time complexity: O(n) Space complexity: O(n)
        PrintUtil.print(test);
    }


}
