package leetcode.NaryTree.easy;

import DS.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 *
 * Constraints:
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */
public class PreOrderTraversal {

    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node != null){
                result.add(node.val);
                if(null != node.children){
                    int size = node.children.size();
                    for(int i=size-1;i>=0;i--){
                        stack.push(node.children.get(i));
                    }
                }

            }
        }
        return result;
    }
}
