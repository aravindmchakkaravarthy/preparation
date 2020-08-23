package leetcode.tree.easy;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfATree {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right)+1;
    }

    public int minDepthDFS(TreeNode root){
        if(null == root) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            depth++;
        }
        return depth;

    }



    public static void main(String[] args){
        TreeNode one = new TreeNode();
        one.val = 1;

        TreeNode two = new TreeNode();
        two.val = 2;

        TreeNode three = new TreeNode();
        three.val = 3;

        TreeNode four = new TreeNode();
        four.val = 4;

        TreeNode five = new TreeNode();
        five.val = 5;

        one.left = two;
        one.right = three;
        //two.left = four;
        three.right = five;

        MinimumDepthOfATree md = new MinimumDepthOfATree();
        System.out.println(md.minDepth(one));
        System.out.println(md.minDepthDFS(one));
    }
}
