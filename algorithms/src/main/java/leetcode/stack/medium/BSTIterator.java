package leetcode.stack.medium;

import DS.TreeNode;

import java.util.Random;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 * Example:
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 */
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode treeNode){
        leftMostNode(treeNode);
    }

    private void leftMostNode(TreeNode root){
        TreeNode curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if(null != node.right){
            leftMostNode(node.right);
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() >0;
    }


    public static void main(String[] args){
        int[] array = new int[100];
        Random random = new Random();
        for(int i=0;i<array.length;i++){
            array[i]=random.nextInt(100-1)+1;
        }
        TreeNode tn = TreeNode.buildBinaryTree(new int[]{7,3,15,9,20});
        BSTIterator bstIterator = new BSTIterator(tn);
        while(bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}
