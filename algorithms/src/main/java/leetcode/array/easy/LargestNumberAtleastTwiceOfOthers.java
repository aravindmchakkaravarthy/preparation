package leetcode.array.easy;

public class LargestNumberAtleastTwiceOfOthers {


    public static int dominantIndexApproach2(int[] nums){
        int m = 0, n =0,mi=-1;
        for (int i=0;i<nums.length;i++){
            if(nums[i] > m){
                n = m;
                m = nums[i];
                mi=i;
            }else if(nums[i] > n){
                n = nums[i];
            }
        }

        if(m>=2*n){
            return mi;
        }else{
            return -1;
        }
    }

    public static int dominantIndex(int[] nums) {
        int max = 0;
        int index = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) {
                max=nums[i];
                index = i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i != index){
                if(nums[i] *2 > max)   {
                    return -1;
                }
            }
        }
        return index;
    }

    public static void main(String args[]){
        int[] nums = {1,1};
        System.out.println(dominantIndex(nums));
        System.out.println(dominantIndexApproach2(nums));
    }
}
