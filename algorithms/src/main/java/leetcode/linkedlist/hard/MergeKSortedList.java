package leetcode.linkedlist.hard;

import DS.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of linked-lists lists, each linked list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sort linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 */
public class MergeKSortedList {

    public ListNode mergeKListsApproach2(ListNode[] lists){
        ListNode head = null;
        ListNode rNext = null;
        if(lists == null || lists.length == 0) return null;
        boolean isFound = true;
        while(isFound){
            int min=-1;
            for(int i=0;i<lists.length;i++){
                if(lists[i] != null){
                    if(min == -1){
                        min = i;
                    }else{
                        if(lists[i].val < lists[min].val){
                            min = i;
                        }
                    }
                }
            }
            if(min == -1){
                isFound = false;
            }else{
                ListNode node = lists[min];
                if(head == null){
                    head = node;
                    rNext = head;
                }else{
                    rNext.next = node;
                    rNext = rNext.next;
                }
                lists[min] = node.next;
            }
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode list:lists){
            if(list != null){
                q.add(list);
            }
        }
        while(!q.isEmpty()){
            ListNode node = q.poll();
            if(head == null){
                head = node;
                curr = head;
            }else{
                curr.next = node;
                curr = curr.next;
            }
            if(node.next != null){
                q.add(node.next);
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);

        node1.next = node12;
        node1.next.next = node13;

        ListNode node2 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);

        node2.next = node22;
        node2.next.next = node23;

        ListNode node3 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        ListNode node33 = new ListNode(11);

        node3.next = node32;
        node3.next.next = node33;

        MergeKSortedList kSortedList = new MergeKSortedList();
        //ListNode newHead = kSortedList.mergeKLists(new ListNode[]{node1, node2, node3});

        ListNode newHead = kSortedList.mergeKListsApproach2(new ListNode[]{node1, node2, node3});

        while(newHead != null){
            System.out.print(newHead.val + "->");
            newHead = newHead.next;
        }

    }


}
