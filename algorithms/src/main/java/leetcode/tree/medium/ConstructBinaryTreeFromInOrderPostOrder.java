package leetcode.tree.medium;

import DS.TreeNode;
import java.util.Stack;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromInOrderPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        int pp = postorder.length - 1;
        int io = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[pp--]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while(pp>=0){
            while(!stack.isEmpty() && stack.peek().val == inorder[io]){
                prev = stack.pop();
                io--;
            }
            TreeNode newNode = new TreeNode(postorder[pp--]);
            if(prev != null){
                prev.left = newNode;
            }else if (!stack.isEmpty()){
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
        }
        return root;
    }

    public static void main(String[] args){
        ConstructBinaryTreeFromInOrderPostOrder cs = new ConstructBinaryTreeFromInOrderPostOrder();
        int[] io = {9,3,15,20,7}; int[] po = {9,15,7,20,3};
        TreeNode root = cs.buildTree(io, po);
    }
}
