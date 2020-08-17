package leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryZigZagOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        current.push(root);
        boolean leftToRight = false;
        List<Integer> list = new ArrayList<>();
        while(!current.isEmpty()){
            TreeNode node = current.pop();
            list.add(node.val);
            if(leftToRight){
                if(node.left != null){
                    next.push(node.left);
                }
                if(node.right != null){
                    next.push(node.right);
                }
            }else{
                if(node.right != null){
                    next.push(node.right);
                }
                if(node.left != null){
                    next.push(node.left);
                }
            }
            if(current.isEmpty()){
                Stack<TreeNode> temp = current;
                current = next;
                next = temp;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
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

        BinaryZigZagOrderTraversal bzzot = new BinaryZigZagOrderTraversal();
        System.out.println(bzzot.zigzagLevelOrder(treeNode));

    }
}
