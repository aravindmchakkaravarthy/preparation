package leetcode.tree.medium;

import DS.TreeNode;
import java.util.Stack;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreePreorderInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int j = 0;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode curr = new TreeNode(preorder[i]);
            while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                prev = stack.pop();
                j++;
            }
            if(prev != null){
                prev.right = curr;
                prev = null;
            }else{
                stack.peek().left = curr;
            }
            stack.push(curr);
        }
        return root;
    }

    public static void main(String[] args){
        ConstructBinaryTreePreorderInorder cs = new ConstructBinaryTreePreorderInorder();
        int[] io = {9,3,15,20,7}; int[] po = {3,9,20,15,7};
        TreeNode root = cs.buildTree(po,io);
    }
}
