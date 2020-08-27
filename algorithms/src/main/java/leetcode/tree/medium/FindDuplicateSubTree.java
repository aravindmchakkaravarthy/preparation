package leetcode.tree.medium;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateSubTree {

    public void print(TreeNode node, List<Integer> list){

    }

    public void postOrder(TreeNode node){
        print(node, new ArrayList<>());
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        return null;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);

        TreeNode three1 = new TreeNode(3);
        TreeNode two1 = new TreeNode(2);
        TreeNode four1 = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);

        node.left = two;
        node.left.left = four;

        node.right = three1;
        node.right.left = two1;
        node.right.left.left = four1;
        node.right.right = four2;

        FindDuplicateSubTree tree = new FindDuplicateSubTree();
        tree.postOrder(node);



    }
}
