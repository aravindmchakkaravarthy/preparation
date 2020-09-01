package leetcode.tree.easy;

import DS.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public void helper(TreeNode node, List<List<Integer>> answer, List<Integer> path){
        if(node == null) return;
        path.add(node.val);
        if(node.left == null && node.right == null){
            answer.add(path);
        }
        helper(node.left, answer, new ArrayList<>(path));
        helper(node.right, answer, new ArrayList<>(path));
    }

    public List<List<Integer>> getTreePath(TreeNode node){
        List<List<Integer>> answer = new ArrayList<>();
        helper(node, answer, new ArrayList<>());
        return answer;

    }

    public void path(TreeNode node, List<String> answer, String path){
        if(node == null) return;
        if(node.left == null && node.right == null) answer.add(path + node.val);
        path(node.left, answer, path+node.val+"->");
        path(node.right, answer, path+node.val+"->");
    }



    public List<String> binaryTreePaths(TreeNode node){
        List<String> paths = new ArrayList<>();
        path(node, paths, "");
        return paths;
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

        BinaryTreePaths treePaths = new BinaryTreePaths();
        System.out.println(treePaths.getTreePath(r));
        System.out.println(treePaths.binaryTreePaths(r));
    }
}
