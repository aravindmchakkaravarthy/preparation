package leetcode.linkedlist.medium;

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
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int reminder = 0;
        ListNode root = null;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode currL3 = null;
        while(null != currL1 || null != currL2){
            int l1Val = currL1 == null ? 0 : currL1.val;
            int l2Val = currL2 == null ? 0 : currL2.val;
            currL1 = currL1 == null ? null : currL1.next;
            currL2 = currL2 == null ? null : currL2.next;
            int sum = l1Val + l2Val + reminder;
            int val;
            if(sum >= 10){
                val = sum - 10;
                reminder = 1;
            }else{
                val = sum;
                reminder = 0;
            }
            if(null == root){
                root = new ListNode(val);
                root.val = val;
                currL3 = root;
            }else{
                ListNode next = new ListNode(val);
                currL3.next = next;
                currL3 = next;
            }
        }
        if(reminder > 0){
            currL3.next = new ListNode(reminder);
        }
        return root;
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

        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode ln = atn.addTwoNumbers(l1, l2);

        System.out.println(ln);




    }
}
