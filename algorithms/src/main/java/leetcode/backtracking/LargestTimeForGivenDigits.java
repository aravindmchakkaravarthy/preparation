package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * <p>
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * <p>
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 * <p>
 * Input: A = [5,5,5,5]
 * Output: ""
 * Example 3:
 * <p>
 * Input: A = [0,0,0,0]
 * Output: "00:00"
 * Example 4:
 * <p>
 * Input: A = [0,0,1,0]
 * Output: "10:00"
 */
public class LargestTimeForGivenDigits {

    static class ClockComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> a, List<Integer> b) {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            } else if (!a.get(1).equals(b.get(1))) {
                return a.get(1) - b.get(1);
            } else if (!a.get(2).equals(b.get(2))) {
                return a.get(2) - b.get(2);
            } else {
                return a.get(3) - b.get(3);
            }
        }
    }

    private boolean isValidTime(List<Integer> time) {
        return (time != null && time.size() == 4 && time.get(0) <= 2 && (time.get(1) <= 3 || time.get(0) <= 1) && time.get(2) <= 5);

    }

    private void helper(List<List<Integer>> result, List<Integer> permute, int[] arr, boolean[] visited) {
        if (permute.size() == 4) {
            if (isValidTime(permute)) {
                result.add(new ArrayList<>(permute));
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            permute.add(arr[i]);
            visited[i] = true;
            helper(result, permute, arr, visited);
            visited[i] = false;
            permute.remove(permute.size() - 1);
        }
    }

    public String largestTimeFromDigits(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), arr, new boolean[4]);
        if (result.size() == 0) return "";
        result.sort(new ClockComparator());
        List<Integer> answer = result.get(result.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x);
            if (sb.length() == 2) {
                sb.append(":");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};
        LargestTimeForGivenDigits l = new LargestTimeForGivenDigits();
        System.out.println(l.largestTimeFromDigits(input));

    }

}
