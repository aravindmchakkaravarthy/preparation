package leetcode.linkedlist.easy;

import DS.ListNode;
import util.PrintUtil;

public class RemoveLinkListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            if(curr.val == val){
                if(prev == null){
                    head = curr.next;
                }else{
                    prev.next = curr.next;
                }
                curr = curr.next;
            }else{
                ListNode temp = curr.next;
                prev = curr;
                curr = temp;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        RemoveLinkListElements removeLinkListElements = new RemoveLinkListElements();
        ListNode head = removeLinkListElements.removeElements(one, 3);
        PrintUtil.print(head);
    }


}
