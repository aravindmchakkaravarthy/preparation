package leetcode.bst.medium;

import DS.TreeNode;
import leetcode.tree.hard.SerializeAndDeserializeABinaryTree;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class DeleteNodeInABST {

    private TreeNode deleteRoot(TreeNode root){
        if(root == null) return null;
        else if(root.left == null && root.right == null) return null;
        else if(root.left == null || root.right == null){
            return (root.left == null) ? root.right : root.left;
        }else{
            TreeNode successor = root.right;
            TreeNode left = successor;
            while(left.left != null){
                left = left.left;
            }
            left.left = root.left;
            return successor;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key){
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null){
            if(curr.val == key){
                break;
            }
            prev = curr;
            if(curr.val > key){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        if(curr != null){
            if(prev == null){
                return deleteRoot(root);
            }else{
                if(prev.val > key){
                    prev.left = deleteRoot(curr);
                }else{
                    prev.right = deleteRoot(curr);
                }
            }
        }
        return root;
    }

    public static void main(String[] args){

        TreeNode root = TreeNode.buildBinaryTree(new int[]{5,3,6,2,4,7});
        DeleteNodeInABST d = new DeleteNodeInABST();
        TreeNode t = d.deleteNode(root, 3);

        SerializeAndDeserializeABinaryTree s = new SerializeAndDeserializeABinaryTree();
        System.out.println(s.serialize(t));
    }
}
