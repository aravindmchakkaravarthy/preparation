package leetcode.array.medium;

import leetcode.linkedlist.hard.MergeKSortedList;
import util.PrintUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 *
 *
 * Constraints:
 *
 * intervals[i][0] <= intervals[i][1]
 */
public class MergeIntervals {

    private class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            return Integer.compare(a[0], b[0]);
        }
    }
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval:intervals){
            if(merged.size() == 0 || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args){
        int[][] ar = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mi = new MergeIntervals();
        mi.merge(ar);
    }
}
