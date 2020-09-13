package leetcode.linkedlist.medium;

import DS.ListNode;
import DS.TreeNode;
import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertListToBST {

    private TreeNode binarySearchTree(List<Integer> list, int l, int r) {
        if(l>r){
            return null;
        }
        int mid = (l + r)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = binarySearchTree(list, l, mid-1);
        root.right = binarySearchTree(list, mid+1, r);
        return root;
    }


    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return binarySearchTree(list, 0, list.size()-1);
    }

    public static void main(String[] args){
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        ConvertListToBST c = new ConvertListToBST();
        TreeNode node = c.sortedListToBST(list);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(null != curr){
                result.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        System.out.println(result);

    }
}
