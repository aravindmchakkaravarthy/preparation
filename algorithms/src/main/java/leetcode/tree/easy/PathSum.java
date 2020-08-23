package leetcode.tree.easy;

import DS.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {



    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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


        PathSum ps = new PathSum();
        System.out.println(ps.hasPathSum(one, 9));
        System.out.println(ps.hasPathSum(one, 7));
        System.out.println(ps.hasPathSum(one, 10));

    }
}
