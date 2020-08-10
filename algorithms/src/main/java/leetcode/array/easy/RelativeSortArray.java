package leetcode.array.easy;

import java.util.*;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */
public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int x:arr1) {
            map.put(x, map.getOrDefault(x,0)+1);
            if(!list.contains(x)){
                list.add(x);
            }
        }
        int i = 0;
        for(int x:arr2){
            int count = map.get(x);
            list.remove(Integer.valueOf(x));
            int thisCount = 0;
            while(thisCount<count){
                arr1[i++] = x;
                thisCount++;
            }
        }
        Collections.sort(list);
        for(int x:list){
            int count = map.get(x);
            int thisCount = 0;
            while(thisCount<count){
                arr1[i++] = x;
                thisCount++;
            }
        }
        return arr1;

    }

    public static void main(String[] args){
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        relativeSortArray(arr1, arr2);
        PrintUtil.print(arr1);
    }
}
