package leetcode.tree.easy;

import DS.TreeNode;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth_MultipleApproaches {

    public int maxDepthIterative(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.add(root);
        int d = 0;
        while(!queue.isEmpty()){
            int s = queue.size();
            d++;
            for(int i=0;i<s;i++){
                TreeNode node = queue.poll();
                if(null != node.left){
                    queue.add(node.left);
                }
                if(null != node.right){
                    queue.add(node.right);
                }
            }
        }

        return d;
    }

    int answer = 0;
    public void helper(TreeNode root, int depth){
        if(root==null){
            return;
        }
        if(root.left == null && root.right == null){
            answer = Math.max(answer, depth);
        }
        helper(root.left, depth+1);
        helper(root.right, depth+1);

    }

    public int maxDepthRecursiveTopDown(TreeNode root){
        helper(root, 1);
        return answer;
    }

    public int maxDepthRecursiveBottomUp(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepthRecursiveBottomUp(root.left);
        int right = maxDepthRecursiveBottomUp(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args){
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

        MaxDepth_MultipleApproaches md = new MaxDepth_MultipleApproaches();
        System.out.println(md.maxDepthIterative(r));
        System.out.println(md.maxDepthRecursiveBottomUp(r));
        System.out.println(md.maxDepthRecursiveTopDown(r));

    }
}
