package leetcode.tree.medium;

import util.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        double prev = - Double.MAX_VALUE;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr.val <= prev) return false;
            prev = curr.val;
            curr = curr.right;
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode root = TreeNode.buildBinaryTree(new int[]{2,1,3});
        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
        System.out.println(validBinarySearchTree.isValidBST(root));

    }
}
