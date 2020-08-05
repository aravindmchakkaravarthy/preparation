package leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicateApproach2(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0;
        for(int j=0;j<nums.length;j++){
            if(!set.add(nums[j])){
                return true;
            }
            if(set.size() >= k+1){
                set.remove(nums[i++]);
            }
        }
        return false;

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                if(i - j <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }



    public static void main(String args[]){
        int[] test = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(test, 3));
        System.out.println(containsNearbyDuplicate(test, 3)); // Approach 2 - using hashset. only storing upto k elements.
    }
}
