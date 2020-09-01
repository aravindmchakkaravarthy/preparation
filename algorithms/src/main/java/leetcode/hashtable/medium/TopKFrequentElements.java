package leetcode.hashtable.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for(int x:nums){
            count.put(x, count.getOrDefault(x,0)+1);
        }
        int[] result = new int[k];
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> count.get(o1) - count.get(02) );
        for(int n: count.keySet()){
            priorityQueue.add(n);
            if(priorityQueue.size()>k) priorityQueue.poll();
        }
        for(int i=k-1;i>=0;i--){
            result[i] = priorityQueue.poll();
        }
        return result;

    }
}
