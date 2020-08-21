package leetcode.stack.medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * <p>
 * <p>
 * Example:
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 */
public class BSTIteratorII {

    private Queue<TreeNode> queue = new LinkedList<>();

    public BSTIteratorII(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            queue.add(current);
            current = current.right;
        }

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll().val;

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return queue.size() > 0;

    }
}
