package leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryPreOrderTraversal {

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result){
        if(root != null){
            result.add(root.val);
            helper(root.left, result);
            helper(root.right, result);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> curr = new Stack<>();
        curr.push(root);
        while(!curr.isEmpty()){
            TreeNode node = curr.pop();
            if(node != null){
                result.add(node.val);
                curr.add(node.right);
                curr.add(node.left);
            }

        }
        return result;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode();
        treeNode.val = 2;

        TreeNode left = new TreeNode();
        left.val = 3;

        TreeNode right = new TreeNode();
        right.val = 1;



        TreeNode leftRightChild = new TreeNode();
        leftRightChild.val = 5;

        TreeNode leftRightRightChild = new TreeNode();
        leftRightRightChild.val = 4;

        left.right = leftRightChild;
        leftRightChild.right = leftRightRightChild;
        treeNode.left = left;
        treeNode.right = right;

        BinaryPreOrderTraversal bpot = new BinaryPreOrderTraversal();
        System.out.println(bpot.preorderTraversalRecursive(treeNode));
        System.out.println(bpot.preorderTraversal(treeNode));

    }
}
