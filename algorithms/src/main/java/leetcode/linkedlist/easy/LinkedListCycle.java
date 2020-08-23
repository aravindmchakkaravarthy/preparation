package leetcode.linkedlist.easy;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast == null) return false;
            fast = fast.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        LinkedListCycle cycle = new LinkedListCycle();
        System.out.println(cycle.hasCycle(one));
        four.next = null;
        System.out.println(cycle.hasCycle(one));

    }
}
