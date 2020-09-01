package leetcode.bst.easy;

import DS.TreeNode;
import leetcode.tree.hard.SerializeAndDeserializeABinaryTree;

/**
 *Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree will be between 0 and 10^4.
 * Each node will have a unique integer value from 0 to -10^8, inclusive.
 * -10^8 <= val <= 10^8
 * It's guaranteed that val does not exist in the original BST.
 */
public class InsertIntoABST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null){
            prev = curr;
            if(curr.val >= val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }

        }
        if(prev.val > val){
            prev.left = new TreeNode(val);
        }else{
            prev.right = new TreeNode(val);
        }
        return root;

    }

    public static void main(String[] args){
        SerializeAndDeserializeABinaryTree s = new SerializeAndDeserializeABinaryTree();

        TreeNode node = s.deseriaLize("[5,null,14,10,77,null,null,null,95,null,null]");
        InsertIntoABST insertIntoABST = new InsertIntoABST();
        TreeNode root = insertIntoABST.insertIntoBST(node, 25);
        System.out.println(root);

    }
}
