package leetcode.tree.hard;

import DS.TreeNode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

public class SerializeAndDeserializeABinaryTree {

    private TreeNode getTreeNode(String[] nodes, int i){
        if(i<0 || i>=nodes.length || nodes[i].equals("null")) return null;
        try{
            return new TreeNode(Integer.parseInt(nodes[i]));
        }catch (Exception E){
            return null;
        }
    }

    private String getNodeVal(TreeNode node){
        return node == null ? "null" : String.valueOf(node.val);
    }



    public String serialize(TreeNode root){
        ArrayList<String> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        nodes.add(getNodeVal(root));
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                nodes.add(getNodeVal(left));
                nodes.add(getNodeVal(right));
                if(null != right){
                    stack.push(right);
                }
                if(null != left){
                    stack.push(left);
                }
            }
        }
        int x = 0;
        for(int i=0;i<nodes.size();i++){
            if(!nodes.get(i).equals("null")){
                x = i;
            }
        }

        String s = String.join(",", nodes.subList(0, x+1));
        return "[" + s+"]";
    }

    public TreeNode deseriaLize(String data){
        data = data.replace("[", "").replace("]","");
        String[] nodes = data.split(",");
        int j =0;
        if(nodes.length == 0 || nodes[j].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[j++]));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                TreeNode left = getTreeNode(nodes, j++);
                TreeNode right = getTreeNode(nodes, j++);
                node.left = left;
                node.right = right;
                if(right != null){
                    stack.push(right);
                }
                if(left != null){
                    stack.push(left);
                }
            }
        }
        return root;
    }

    public static void main(String[] args){
        SerializeAndDeserializeABinaryTree bt = new SerializeAndDeserializeABinaryTree();

        String s = "[1,2,3,null,null,4,5]";
        TreeNode node = bt.deseriaLize(s);
        String o = bt.serialize(node);
        System.out.println(o);
        if(s.equals(o)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        //TODO Analyze other better methods.... when serializing removing the nulls in the end seems unnecesaary step.

    }
}
