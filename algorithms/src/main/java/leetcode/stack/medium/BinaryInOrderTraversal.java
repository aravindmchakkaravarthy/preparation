package leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class BinaryInOrderTraversal {
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public List < Integer > inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode current = root;
       while(current != null || !stack.isEmpty()){
           while(current != null){
               stack.push(current);
               current = current.left;
           }
           current = stack.pop();
           res.add(current.val);
           current = current.right;
       }
       return res;
    }

    public void helper(TreeNode root, List<Integer> res ){
        if(null != root){
            if(root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if(root.right != null){
                helper(root.right, res);
            }
        }
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode();
        treeNode.val = 3;

        TreeNode left = new TreeNode();
        left.val = 9;

        TreeNode right = new TreeNode();
        right.val = 20;

        TreeNode rightLeftChild = new TreeNode();
        rightLeftChild.val = 15;

        TreeNode rightRightChild = new TreeNode();
        rightRightChild.val = 7;

        treeNode.left = left;
        treeNode.right = right;

        right.left = rightLeftChild;
        right.right = rightRightChild;

        treeNode.left = left;
        treeNode.right = right;


        BinaryInOrderTraversal biot = new BinaryInOrderTraversal();

        System.out.println(biot.inorderTraversalRecursive(treeNode));
        System.out.println(biot.inorderTraversal(treeNode));
    }

}
