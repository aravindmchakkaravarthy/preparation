package leetcode.array.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 *
 * Example 1:
 * Input: [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 *     After flipping, the maximum number of consecutive 1s is 4.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
 */
public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnesApproach2(int[] nums){
        int max = 0, k = 1, zero = 0;
        for(int l=0,h=0;h<nums.length;h++){
            if(nums[h] == 0)zero++;
            while(zero>k){
                if(nums[l++] == 0) zero--;
            }
            max = Math.max(max, h-l+1);
        }
        return max;
    }

    public int findMaxConsecutiveOnesApproach3(int[] nums){
        int max = 0, k = 1;
        Queue<Integer> zeroIndex = new ArrayDeque<>();
        for(int l=0,h=0;h<nums.length;h++){
            if(nums[h] == 0) zeroIndex.offer(h);
            while(zeroIndex.size()>k){
                l = zeroIndex.poll() + 1;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        boolean flipped = false;
        int lastFlip = -1;
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                curr++;
            }else{
                if(!flipped){
                    flipped = true;
                    lastFlip = i;
                    curr++;
                }else{
                    max = Math.max(max, curr);
                    curr = i - lastFlip;
                    lastFlip = i;
                }
            }
        }
        return Math.max(max, curr);
    }
}
