package leetcode.linkedlist.easy;


import DS.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null, curr = null;
        while(null != l1 || null != l2){
            int val;
            if(null == l2 || (null!= l1 && l1.val<=l2.val)){
                val = l1.val;
                l1 = l1.next;
            }else{
                val = l2.val;
                l2 = l2.next;
            }
            if(root == null){
                root = new ListNode(val);
                curr = root;
            }else{
                ListNode next = new ListNode(val);
                curr.next = next;
                curr = next;
            }
        }
        return root;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l12 = new ListNode();
        l12.val = 2;

        ListNode l13 = new ListNode();
        l13.val = 4;

        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode();
        l2.val = 1;

        ListNode l22 = new ListNode();
        l22.val = 3;

        ListNode l23 = new ListNode();
        l23.val = 4;

        l2.next = l22;
        l22.next = l23;

        MergeSortedLists msl = new MergeSortedLists();
        ListNode l3 = msl.mergeTwoLists(l1, l2);
        System.out.println(l3);

    }
}
