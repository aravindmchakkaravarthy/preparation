package leetcode.array.easy;

import jdk.swing.interop.SwingInterOpUtils;

public class MaximumAverageSubArry {

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        if(k == nums.length){
            for(int x:nums){
                sum +=x;
            }
            return sum/k;
        }
        for (int i =0;i < nums.length - k+1;i++){
            System.out.println(nums[i]);
            int x = 0;
            int temp = 0;
            while(x<k){
                temp +=nums[i+x];
                x++;
            }
            if(sum<temp){
                sum = temp;
            }
        }

        return sum/k;

    }

    public static void main(String[] args){
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
