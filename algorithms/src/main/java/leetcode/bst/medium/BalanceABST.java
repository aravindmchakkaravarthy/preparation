package leetcode.bst.medium;

import leetcode.stack.medium.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree, return a balanced binary search tree with the same node values.
 *
 * A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
 *
 * If there is more than one answer, return any of them.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The tree nodes will have distinct values between 1 and 10^5.
 */
public class BalanceABST {

    public TreeNode constructBST(int left, int right, List<Integer> inOrderList){
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(inOrderList.get(left));
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(inOrderList.get(mid));
        node.left = constructBST(left, mid - 1, inOrderList);
        node.right = constructBST(mid + 1, right, inOrderList);

        return node;
    }



    public TreeNode balanceBST(TreeNode root) {
        if(null == root) return null;
        List<Integer> nos = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(null != curr || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nos.add(curr.val);
            curr = curr.right;
        }
        return constructBST(0, nos.size()-1, nos);
    }

    public static void main(String[] args){

        TreeNode root = TreeNode.buildBinaryTree(new int[]{14,9,16,2,13});
        BalanceABST balanceABST = new BalanceABST();
        TreeNode result = balanceABST.balanceBST(root);
        System.out.println(result);

    }
}
