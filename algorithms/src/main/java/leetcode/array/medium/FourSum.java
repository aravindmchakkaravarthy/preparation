package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> list = new ArrayList<>();
        int l = start;
        int r = nums.length-1;
        while(l<r){
            int sum = nums[l] + nums[r];
            if(sum<target || (l>start && nums[l] == nums[l-1])){
                l++;
            }else if(sum>target || (r<nums.length-1 && nums[r] == nums[r+1])){
                r--;
            }else{
                list.add(Arrays.asList(nums[l++], nums[r--]));
            }
        }
        return list;


    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
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
    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if(start > nums.length || nums[start] * k > target || target > nums[nums.length-1]*k){
            return res;
        }
        if(k==2){
            return twoSum(nums, target, start);
        }
        for(int i=start;i<nums.length;++i){
            if(i==start || nums[i] != nums[i-1]) {
                for(var set:kSum(nums, target - nums[i], i+1,k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(set);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static void main(String[] args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));

    }
}
