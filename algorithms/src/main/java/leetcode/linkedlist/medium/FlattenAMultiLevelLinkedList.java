package leetcode.linkedlist.medium;

import DS.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 *
 * The multilevel linked list in the input is as follows:
 */
public class FlattenAMultiLevelLinkedList {

    public void helper(Node head, List<Integer> list){
        if(head != null){
            list.add(head.val);
            helper(head.child,list);
            helper(head.next,list);
        }

    }

    public Node flatten(Node head) {
        List<Integer> list = new ArrayList<>();
        helper(head, list);
        Node node = null;
        Node prev = null;
        for(int x:list){
            Node thisNode = new Node(x);
            if(node == null){
                node = thisNode;
                prev = node;
            }else{
                thisNode.prev = prev;
                prev.next = thisNode;
                prev = thisNode;
            }

        }
        return node;
    }


    public static void main(String[] args){
        new FlattenAMultiLevelLinkedList().flatten(new Node()); // add examples

        //TODO - just do recursive with no extra space.


    }


}
