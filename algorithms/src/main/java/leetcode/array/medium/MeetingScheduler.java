package leetcode.array.medium;

import java.util.*;

/**
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
 *
 * If there is no common time slot that satisfies the requirements, return an empty array.
 *
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 *
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 *
 *
 *
 * Example 1:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * Example 2:
 *
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 */
public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int[][] allSlots = new int[slots1.length+slots2.length][2];
        int pos = 0;
        for(int[] interval:slots1)allSlots[pos++] = interval;
        for(int[] interval:slots2)allSlots[pos++] = interval;
        Collections.sort(Arrays.asList(allSlots), (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<allSlots.length-1;i++){
            if(allSlots[i][1]-allSlots[i+1][0] >=duration && allSlots[i+1][1] - allSlots[i+1][0]>=duration){
                result.add(allSlots[i+1][0]);
                result.add(allSlots[i+1][0]+duration);
                break;
            }
        }
        return result;
    }

    public List<Integer> minAvailableDurationApproach2(int[][] slots1, int[][] slots2, int duration){

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int[] slot:slots1)if(slot[1] - slot[0] >= duration)q.offer(slot);
        for(int[] slot:slots2)if(slot[1] - slot[0] >= duration)q.offer(slot);
        while(q.size()>1){
            if(q.poll()[1] - q.peek()[0] >= duration){
                return Arrays.asList(q.peek()[0], q.peek()[0] + duration);
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[][] slots1 = {{10,50},{60,120},{140,210}};
        int[][] slots2 = {{0,15},{60,70}};
        MeetingScheduler ms = new MeetingScheduler();
        System.out.println(ms.minAvailableDuration(slots1, slots2, 8));
        System.out.println(ms.minAvailableDurationApproach2(slots1, slots2, 8));
    }
}
