package leetcode.linkedlist.easy;

import DS.ListNode;


public class PalindromeLinkedList {

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(slow.val != fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
       return true;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode twoN = new ListNode(2);
        ListNode oneN = new ListNode(1);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = twoN;
        twoN.next = oneN;

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(one));
    }
}
