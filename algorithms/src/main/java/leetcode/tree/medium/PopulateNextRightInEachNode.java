package leetcode.tree.medium;

import DS.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next poin
 */
public class PopulateNextRightInEachNode {

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return root;

    }



    public static void main(String[] args) {
        Node r = new Node(1);
        Node l1 = new Node(2);
        Node l1l2 = new Node(3);
        Node l1r2 = new Node(4);
        Node r1 = new Node(3);
        Node r1l1 = new Node(4);
        Node r1l2 = new Node(5);

        l1.left = l1l2;
        l1.right = l1r2;

        r1.left = r1l1;
        r1.right = r1l2;
        r.left = l1;
        r.right = r1;

        PopulateNextRightInEachNode p = new PopulateNextRightInEachNode();
        Node n = p.connect(r);
    }
}
