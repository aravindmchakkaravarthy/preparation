package leetcode.design.medium;

import java.util.*;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 *
 *
 * Example:
 *
 * Input:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].
 *
 *
 * Follow up:
 *
 * What if you are given k 1d vectors? How well can your code be extended to such cases?
 *
 * Clarification for the follow up question:
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:
 *
 * Input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 *
 * Output: [1,4,8,2,5,9,3,6,7].
 */
public class ZigZagIterator {

    Queue<Iterator<Integer>> q;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if(!v1.isEmpty()) q.add(v1.iterator());
        if(!v2.isEmpty()) q.add(v2.iterator());
    }

    public int next() {
        if(hasNext()){
            Iterator<Integer> it = q.poll();
            int x = it.next();
            if(it.hasNext()) q.offer(it);
            return x;
        }
        return -1;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public static void main(String[] args){
        List<Integer> l1 = Arrays.asList(1,2);
        List<Integer> l2 = Arrays.asList(3,4,5,6);
        ZigZagIterator zt = new ZigZagIterator(l1, l2);
        System.out.println(zt.next());
        System.out.println(zt.next());
        System.out.println(zt.next());
        System.out.println(zt.next());
        System.out.println(zt.next());
        System.out.println(zt.next());
        System.out.println(zt.next());
    }
}
