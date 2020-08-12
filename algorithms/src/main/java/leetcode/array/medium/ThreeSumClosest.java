package leetcode.array.medium;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentTarget = -1;
        for(int i=0;i<nums.length-2;i++){
            int l= i+1;
            int r= nums.length-1;
            while(l<r){
                int newTarget = nums[i] + nums[l] + nums[r];
                if ((i==0 && l==1 && r==nums.length-1) || Math.abs(target - newTarget) < Math.abs(target - currentTarget)){
                    currentTarget = newTarget;
                }
                if(newTarget<=target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return currentTarget;

    }

    public static void main(String[] args){

        System.out.println(threeSumClosest(new int[]{1,1,-1,-1,3}, -1));

    }
}
