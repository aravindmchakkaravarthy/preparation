package leetcode.tree.easy;

import DS.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryLevelOrderTraversalII {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Queue<TreeNode> next = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(null != curr){
                list.add(curr.val);
                if(curr.left != null) next.add(curr.left);
                if(curr.right != null) next.add(curr.right);
            }
            if(queue.isEmpty()){
                if(list.size()>0){
                    res.add(0, list);
                }
                list = new ArrayList<>();
                Queue<TreeNode> temp = queue;
                queue = next;
                next = temp;
            }
        }
        return res;
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

        BinaryLevelOrderTraversalII levelOrderTraversal = new BinaryLevelOrderTraversalII();
        System.out.println(levelOrderTraversal.levelOrderBottom(one));

    }


}
