package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 */
public class MinimumAbsoluteDifference {

    private static List<Integer> getResult(int x, int y){
        List<Integer> result = new ArrayList<>();
        result.add(Math.min(x, y));
        result.add(Math.max(x, y));
        return result;
    }

    public static List<List<Integer>> minimumAbsDifferenceApproach2(int[] arr){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int min = -1;
        int start =0;
        while(start < arr.length-1){
            int thisMin = Math.abs(arr[start]-arr[start+1]);
            if(min == -1){
                min = thisMin;
                list.add(getResult(arr[start], arr[start+1]));
            }
            //TODO handle same numbers
            else if(thisMin <= min){
                if(thisMin <min){
                    list.clear();
                }
                min = thisMin;
                list.add(getResult(arr[start], arr[start+1]));
            }
            start++;
        }
        return list;
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {//brute force
        List<List<Integer>> list = new ArrayList<>();
        int min = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(i==0 && j==1){
                    min = Math.abs(arr[i] - arr[j]);
                }
                min = Math.min(min, Math.abs(arr[i] - arr[j]));
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(Math.abs(arr[i]-arr[j]) == min){
                    List<Integer> result = new ArrayList<>();
                    result.add(Math.min(arr[i], arr[j]));
                    result.add(Math.max(arr[i], arr[j]));
                    list.add(result);
                }
            }
        }
        list.sort(new Comparator<List<Integer>>(){

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        return list;
    }

    public static void main(String[] args){
        int[] nums = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(nums));
        System.out.println(minimumAbsDifferenceApproach2(nums));
    }
}
