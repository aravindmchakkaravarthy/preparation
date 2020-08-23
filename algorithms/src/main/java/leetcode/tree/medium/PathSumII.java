package leetcode.tree.medium;
import util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {

    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<Integer>(path));
        }else{
            helper(root.left, sum - root.val, path, res);
            helper(root.right, sum - root.val, path, res);
        }
        path.remove(path.size()-1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), res);
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


        PathSumII ps = new PathSumII();
        System.out.println(ps.pathSum(one, 9));
        System.out.println(ps.pathSum(one, 7));
        System.out.println(ps.pathSum(one, 10));
    }
}
