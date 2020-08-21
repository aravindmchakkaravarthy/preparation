package leetcode.tree.easy;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(null == t1 && null == t2) return true;
        if(null == t1 || null == t2) return false;
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t2.left, t1.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isSymmetricIterative(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(null == t1 && null == t2) continue;
            if(null == t1 || null == t2) return false;
            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode one = new TreeNode();
        one.val = 1;
        String s = "ax";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse().toString());
        TreeNode two = new TreeNode();
        two.val = 2;

        TreeNode twoR= new TreeNode();
        twoR.val = 2;

        TreeNode three = new TreeNode();
        three.val = 3;

        TreeNode threeR= new TreeNode();
        threeR.val = 3;

        TreeNode four = new TreeNode();
        four.val = 2;

        TreeNode fourR= new TreeNode();
        fourR.val = 2;

        SymmetricTree st = new SymmetricTree();
        System.out.println(st.isSymmetric(one));
        System.out.println(st.isSymmetricIterative(one));

    }
}
