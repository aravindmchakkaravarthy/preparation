package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 * <p>
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * <p>
 * It is guaranteed that the insertion operations will be valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * Example 3:
 * <p>
 * Input: nums = [1], index = [0]
 * Output: [1]
 */
public class CreateTargetArrayInGivenOrder {

    public static int[] createTargetArrayApproach2(int[] nums, int[] index) {
        int[] arr = new int[nums.length];
        int n = 0;
        Arrays.fill(arr, -1);
        for (int i = 0; i < nums.length; i++) {
            if (arr[index[i]] == -1)
                arr[index[i]] = nums[i];
            else {
                n = arr.length - 1;
                while (n != index[i]) {
                    arr[n] = arr[n - 1];
                    n--;
                }
                arr[n] = nums[i];
            }
            PrintUtil.print(arr);
        }
        return arr;
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            int pos = index[i];
            int val = nums[i];
            ans.add(pos, val);
        }
        return ans.stream().mapToInt(value -> value).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4}, index = {0, 1, 2, 2, 1};
        PrintUtil.print(createTargetArray(nums, index));
        PrintUtil.print(createTargetArrayApproach2(nums, index));
    }
}
