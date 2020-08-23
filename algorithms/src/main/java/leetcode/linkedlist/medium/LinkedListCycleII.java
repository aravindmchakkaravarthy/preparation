package leetcode.linkedlist.medium;

import DS.ListNode;
import leetcode.linkedlist.easy.LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycleII {


    /**
     * This approach is based on Floyd's cycle detection algorithm
     * Cycle is found - if fast and slow meets. fast travels two node and slow travels one node.
     * After the cycle is found, point slow to head, move fast and slow once until they meet again. They meet at the beginning of the cycle.
     *
     * @param head
     * @return
     */
    public ListNode detectCycleApproach2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(null != fast && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }



    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            set.add(head);
            if(set.contains(head.next)){
                return head.next;
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        LinkedListCycleII cycle = new LinkedListCycleII();
        System.out.println(cycle.detectCycle(one).val);
        System.out.println(cycle.detectCycleApproach2(one).val);
        four.next = null;
        System.out.println(cycle.detectCycle(one));
        System.out.println(cycle.detectCycleApproach2(one));

    }
}
