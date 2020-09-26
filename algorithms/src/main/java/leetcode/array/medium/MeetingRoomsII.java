package leetcode.array.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MeetingRoomsII {

    public int minMeetingRoomsApproach2(int[][] intervals){
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int count = 0, start = 0, end_ptr = 0;
        while(start < intervals.length){
            if(begin[start]> end[end_ptr]){
                count--;
                end_ptr++;
            }
            count++;
            start++;
        }
        return count;

    }


    public int minMeetingRooms(int[][] intervals) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] meeting:intervals){
            map.put(meeting[0], map.getOrDefault(meeting[0], 0) +1);
            map.put(meeting[1], map.getOrDefault(meeting[1], 0) -1);
        }
        int max = 0, curr = 0;
        for(int value:map.values()){
            max = Math.max(max, curr+=value);
        }
        return max;
    }

    public static void main(String[] args){
        int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(meetingRoomsII.minMeetingRooms(intervals));
        System.out.println(meetingRoomsII.minMeetingRoomsApproach2(intervals));


    }
}
