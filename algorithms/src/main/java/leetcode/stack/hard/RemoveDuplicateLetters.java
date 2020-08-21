package leetcode.stack.hard;


import java.util.Stack;

public class RemoveDuplicateLetters {

    class TreeNode{
        Character val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(Character val) { this.val = val; }
        TreeNode(Character val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    private static TreeNode getParentNode(TreeNode root, Character val){
        if(val == root.val){
            return null;
        }
        if(null == root.left && val < root.val){
            return root;
        }
        if(null == root.right && val > root.val){
            return root;
        }
        if(val < root.val){
            return getParentNode(root.left, val);
        }else{
            return getParentNode(root.right, val);
        }
    }

    private void buildNode(TreeNode root, Character val){
        TreeNode curr = getParentNode(root, val);
        if(null != curr){
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            if(val <=curr.val) {
                curr.left = newNode;
            }else{
                curr.right = newNode;
            }
        }
    }

    private TreeNode getTreeNode(String s){
        TreeNode root = new TreeNode();
        root.val = s.charAt(0);
        for(int i=1;i<s.length();i++){
            buildNode(root, s.charAt(i));
        }
        return root;
    }

    public String removeDuplicateLetters(String s) {
        TreeNode treeNode = getTreeNode(s);
        StringBuilder res = new StringBuilder();
        TreeNode curr = treeNode;
        Stack<TreeNode> stack = new Stack<>();
        while(null != curr || !stack.isEmpty()){
            while(curr !=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.append(curr.val);
            curr = curr.right;
        }
        return res.toString();
    }

    public static void main(String[] args){
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        System.out.println(rdl.removeDuplicateLetters("bcabc"));
    }
}
