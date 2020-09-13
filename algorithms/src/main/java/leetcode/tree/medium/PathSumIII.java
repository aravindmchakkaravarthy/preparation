package leetcode.tree.medium;

import DS.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {

    private void sum(TreeNode root, int sum, int curr, Map<Integer, Integer> map, int[] result){
        if(root == null) return;
        curr += root.val;

        if(curr == sum){
            result[0] = result[0] + 1;
        }
        result[0] = result[0] + map.getOrDefault(curr - sum,0);
        map.put(curr, map.getOrDefault(curr,0)+1);
        sum(root.left, sum, curr, map, result);
        sum(root.right, sum, curr, map, result);
        map.put(curr, map.get(curr) -1);

    }

    public int pathSum(TreeNode root, int sum) {
        int[] result = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        sum(root, sum, 0, map, result);
        return result[0];

    }
}
