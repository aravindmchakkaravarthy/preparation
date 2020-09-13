package leetcode.linkedlist.medium;

import DS.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {

    private ListNode reverse(ListNode l1){
        ListNode prev = null;
        ListNode curr = l1;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode curr = null;
        ListNode prev = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val = 0;
            if(l1 != null && l2 != null){
                val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                val = l1.val;
                l1 = l1.next;
            }else{
                val = l2.val;
                l2 = l2.next;
            }

            val = val + carry;
            curr = new ListNode(val % 10);
            carry = val / 10;
            curr.next = prev;
            prev  = curr;
        }

        if(carry == 1){
            ListNode newNode = new ListNode(1);
            newNode.next = curr;
            curr = newNode;
        }
        return curr;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode();
        l1.val = 2;
        ListNode l12 = new ListNode();
        l12.val = 4;

        ListNode l13 = new ListNode();
        l13.val = 3;

        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode();
        l2.val = 5;

        ListNode l22 = new ListNode();
        l22.val = 6;

        ListNode l23 = new ListNode();
        l23.val = 4;

        l2.next = l22;
        l22.next = l23;

        AddTwoNumbersII atn = new AddTwoNumbersII();
        ListNode ln = atn.addTwoNumbers(l1, l2);//243 + 564 == returns 807

        System.out.println(ln);
        while(ln != null){
            System.out.print(ln.val + "->");
            ln = ln.next;
        }
    }
}
