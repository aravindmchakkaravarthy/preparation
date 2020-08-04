package leetcode.array.easy;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j=0;j<nums.length;j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String args[]){
        int[] nums = {1,1,2};
        System.out.println(removeElement(nums, 2));
        System.out.println(nums);

    }
}
