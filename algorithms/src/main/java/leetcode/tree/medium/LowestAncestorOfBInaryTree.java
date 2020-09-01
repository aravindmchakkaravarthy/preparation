package leetcode.tree.medium;


import DS.TreeNode;

import java.util.*;

public class LowestAncestorOfBInaryTree {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        parent.put(root, null);
        boolean pFound = false, qFound = false;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null){
                stack.push(node.right);
                parent.put(node.right, node);
            }
            if(parent.containsKey(p)) pFound = true;
            if(parent.containsKey(q)) qFound = true;
            if(pFound && qFound) break;
        }
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode x = p;
        while(x != null){
            ancestors.add(x);
            x = parent.get(x);
        }
        x = q;
        while(x != null && !ancestors.contains(x)){
            x = parent.get(x);
        }
        return x;

    }

    public static void main(String[] args){
        TreeNode r = new TreeNode(10);
        TreeNode l1 = new TreeNode(8);
        TreeNode l1l2 = new TreeNode(7);
        TreeNode l1r2 = new TreeNode(9);
        TreeNode r1 = new TreeNode(12);
        TreeNode r1l1 = new TreeNode(11);
        TreeNode r1l2 = new TreeNode(13);

        l1.left = l1l2;
        l1.right = l1r2;

        r1.left = r1l1;
        r1.right = r1l2;
        r.left = l1;
        r.right = r1;

        LowestAncestorOfBInaryTree l = new LowestAncestorOfBInaryTree();
        TreeNode node = l.lowestCommonAncestor(r, r1l1, r1l2);
        System.out.println(node.val);
    }
}
