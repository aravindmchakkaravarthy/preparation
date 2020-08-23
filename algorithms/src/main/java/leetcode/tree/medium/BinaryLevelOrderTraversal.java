package leetcode.tree.medium;

import DS.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
                    res.add(list);
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

        BinaryLevelOrderTraversal  levelOrderTraversal = new BinaryLevelOrderTraversal();
        System.out.println(levelOrderTraversal.levelOrder(one));


    }
}
