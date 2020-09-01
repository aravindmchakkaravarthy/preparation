package leetcode.NaryTree.easy;

import DS.Node;

public class MaximumDepthOfNAryTree {

    int answer = 0;

    private void helper(Node root, int depth){
        if(null == root.children || root.children.size() == 0){
            answer = Math.max(answer, depth);
        }
        for(Node child:root.children){
            helper(child, depth+1);
        }
    }

    public int maxDepthApproach2(Node root){
        if(root == null) return 0;
        helper(root, 1);
        return answer;
    }


    public int maxDepth(Node root) {
        if(root == null) return 0;
        int d = 0;
        for(Node child:root.children){
            int v = maxDepth(child);
            d = Math.max(v, d);
        }
        return d+1;
    }
}
