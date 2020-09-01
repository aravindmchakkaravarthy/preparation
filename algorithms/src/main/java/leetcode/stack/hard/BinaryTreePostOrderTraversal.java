package leetcode.stack.hard;

import DS.TreeNode;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {

    private void helper(TreeNode root, List<Integer> result){
        if(root != null){
            helper(root.left, result);
            helper(root.right, result);
            result.add(root.val);
        }
    }

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> visited = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(null != node){
                if(visited.contains(node)){
                    stack.pop();
                    result.add(node.val);
                }else{
                    visited.add(node);
                    stack.push(node.right);
                    stack.push(node.left);
                }
            }else{
                stack.pop();
            }
        }
        return result;
    }

    public List<Integer> postorderTraversalUsingLinkedList(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        if(null == root) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.addFirst(node.val);

            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return result;
    }


    public static void main(String[] args){

        LinkedList<Integer> ans = new LinkedList<>();
        TreeNode r = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l1l2 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r1 = new TreeNode(3);
        TreeNode r1l1 = new TreeNode(4);
        TreeNode r1l2 = new TreeNode(5);

        l1.left = l1l2;
        l1.right = l1r2;

        r1.left = r1l1;
        r1.right = r1l2;
        r.left = l1;
        r.right = r1;

        BinaryTreePostOrderTraversal bt = new BinaryTreePostOrderTraversal();
        System.out.println(bt.postorderTraversalRecursive(r));
        System.out.println(bt.postorderTraversal(r));
        System.out.println(bt.postorderTraversalUsingLinkedList(r));
    }
}
