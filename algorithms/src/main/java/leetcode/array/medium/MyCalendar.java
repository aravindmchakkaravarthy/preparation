package leetcode.array.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    class ListNode{
        int start;
        int end;
        ListNode next;
        ListNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    ListNode head;

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        int i = 10_000_000;
        Integer floor = map.floorKey(start);
        Integer ceiling = map.ceilingKey(start);
        if((floor == null || map.get(floor)<=start) && (ceiling == null || ceiling>=end)){
            map.put(start, end);
            return true;
        }
        return false;
    }

    public boolean book2(int start, int end){
        if(head == null){
            head = new ListNode(start, end);
        }else{
            ListNode curr = head;
            ListNode prev = null;
            while(curr != null && curr.start<=start){
                if(curr.end>start) return false;
                prev = curr;
                curr = curr.next;
            }
            if(null != curr && end>curr.start){
                return false;
            }
            ListNode node = new ListNode(start, end);
            if(prev == null){
                node.next = curr;
                head = node;
            }else{
                node.next = prev.next;
                prev.next = node;
            }
        }
        return true;
    }

    public static void main(String[] args){
        MyCalendar mc = new MyCalendar();
        System.out.println(mc.book(10, 20));
        System.out.println(mc.book(15, 25));
        System.out.println(mc.book(20, 30));

        System.out.println(mc.book2(10, 20));
        System.out.println(mc.book2(15, 25));
        System.out.println(mc.book2(20, 30));
    }
}
