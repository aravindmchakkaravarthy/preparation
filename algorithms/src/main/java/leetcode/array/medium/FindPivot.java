package leetcode.array.medium;

public class FindPivot {

    public static int findPivotIndex(int[] nums){
        if(nums == null || nums.length == 0) return -1;
        int l =0; int r = nums.length-1;
        while(l<=r){
            int m = l + (r - l)/2;
            if (m > 0 && nums[m] < nums[m-1]) return m -1 ;
            if(nums[l] > nums[m] && nums[r] > nums[m])
                r = m -1;
            else
                l = m+1;

        }
        return nums.length-1;
    }

    public static void main(String args[]){
        System.out.println(findPivotIndex(new int[]{0,1,2,3,4}));//expects 4
        System.out.println(findPivotIndex(new int[]{4,1,2,3,4}));;//expects 0
        System.out.println(findPivotIndex(new int[]{9,0,1,2,3,4,5,6,7}));//expects 0
        System.out.println(findPivotIndex(new int[]{9}));//expects 0
        System.out.println(findPivotIndex(new int[]{5,6,7,8,9,10,11,1}));//expects 6
    }


}
