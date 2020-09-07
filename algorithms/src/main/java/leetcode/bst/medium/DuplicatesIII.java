package leetcode.bst.medium;

import java.util.TreeSet;

public class DuplicatesIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k<=0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long floor = set.floor((long)nums[i]+t);
            Long ceil = set.ceiling((long)nums[i]-t);
            if((floor != null && floor>= nums[i]) || (ceil != null && ceil<=nums[i])){

                return true;
            }
            set.add((long)nums[i]);
            if(i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        //TODO Very interesting implementation using treeset.
        //TODO #Read again
        DuplicatesIII duplicatesIII = new DuplicatesIII();
        System.out.println(duplicatesIII.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3,0));
        System.out.println(duplicatesIII.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2,3));
    }
}
