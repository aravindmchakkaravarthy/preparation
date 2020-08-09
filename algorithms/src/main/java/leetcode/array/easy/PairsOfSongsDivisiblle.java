package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 */
public class PairsOfSongsDivisiblle {

    public static int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        for(int i=0;i<time.length;i++){
            for(int j=i+1;j<time.length;j++){
                if((time[i] + time[j])%60 == 0) result++;
            }
        }
        return result;
    }

    public static int numPairsDivisibleBy60Approach2(int[] time){
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        for(int x:time){
            int mod = x%60;
            int delta = 60 - mod;
            if(mod == 0){
                count += map.getOrDefault(0, 0);
            }else{
                count += map.getOrDefault(delta, 0);
            }
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        return count;

    }

    public static void main(String[] args){
        int[] nums = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(nums));
        System.out.println(numPairsDivisibleBy60Approach2(nums));
    }
}
