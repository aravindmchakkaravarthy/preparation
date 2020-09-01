package leetcode.linkedlist.medium;

import DS.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodeInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = dummy;

        while(first != null && second != null){
            first.next = second.next;

            prev.next = second;
            prev.next.next = first;

            prev = first;
            first = first.next;
            if(first != null && first.next != null){
                second = first.next;
            }else{
                second = null;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;


        SwapNodeInPairs sp = new SwapNodeInPairs();
        ListNode n = sp.swapPairs(one);

        while(n != null){
            System.out.print(n.val + "->");
            n = n.next;
        }


    }

}
