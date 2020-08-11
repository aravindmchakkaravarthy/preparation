package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
 *
 * The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * Output: 2
 * Explanation:
 * For arr1[0]=4 we have:
 * |4-10|=6 > d=2
 * |4-9|=5 > d=2
 * |4-1|=3 > d=2
 * |4-8|=4 > d=2
 * For arr1[1]=5 we have:
 * |5-10|=5 > d=2
 * |5-9|=4 > d=2
 * |5-1|=4 > d=2
 * |5-8|=3 > d=2
 * For arr1[2]=8 we have:
 * |8-10|=2 <= d=2
 * |8-9|=1 <= d=2
 * |8-1|=7 > d=2
 * |8-8|=0 <= d=2
 * Example 2:
 *
 * Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * Output: 2
 * Example 3:
 *
 * Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * Output: 1
 */
public class DistanceValueBtwnTwoArrays {

    private static int binarySearch(int[] arr, int value){
        int closest = Integer.MAX_VALUE;
        int l=0,r=arr.length-1;
        while(l<=r){
            int m = (l+r)/2;
            closest = Math.min(Math.abs(arr[m] - value), closest);
            if(arr[m] == value){
                return 0;
            }
            if(arr[m] > value){
                r = m -1;
            }else{
                l = m +1;
            }
        }
        return closest;
    }

    public static int findTheDistanceValueApproach2(int[] arr1, int[] arr2, int d){
        Arrays.sort(arr2);
        int count = 0;
        for(int x:arr1){
            int dt = binarySearch(arr2, x);
            if(dt >d){
                count++;
            }
        }
        return count;
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int y: arr2){
            set.add(y);
        }
        for(int x:arr1){
            int dt = 0;
            while(dt <= d){
                int yd = x-dt;
                int xd = x + dt;
                if(set.contains(yd) || set.contains(xd)){
                    break;
                }
                if(dt==d) {
                    count++;
                }
                dt++;

            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        //System.out.println(findTheDistanceValue(arr1, arr2, d));

        System.out.println(findTheDistanceValueApproach2(arr1, arr2, d));

    }
}
