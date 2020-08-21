package leetcode.tree.easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaximumDepthOfABinaryTree {

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if (null == root) return 0;
        q.add(root);
        int d = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null) next.add(curr.left);
            if(curr.right != null) next.add(curr.right);
            if(q.isEmpty()){
                d++;
                Queue<TreeNode> temp = q;
                q = next;
                next = temp;
            }
        }
        return d;
    }

    public static void main(String[] args){
        TreeNode one = new TreeNode();
        one.val = 1;

        TreeNode two = new TreeNode();
        two.val = 2;

        TreeNode three = new TreeNode();
        three.val = 3;

        TreeNode four = new TreeNode();
        four.val = 4;

        TreeNode five = new TreeNode();
        five.val = 5;

        one.left = two;
        one.right = three;
        two.left = four;
        three.right = five;

        MaximumDepthOfABinaryTree mdbt = new MaximumDepthOfABinaryTree();
        System.out.println(mdbt.maxDepth(one));
    }
}
