package leetcode.tree.easy;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class SameTree {

    public boolean isSameTreeRecursion(TreeNode p, TreeNode q){
        if(null == p && null == q){
            return true;
        }else if (null == p || null == q){
            return false;
        }else if (p.val != q.val){
            return false;
        }
        return isSameTreeRecursion(p.left, q.left) && isSameTreeRecursion(p.right, q.right);
    }

    public boolean check(TreeNode p, TreeNode q){
        if(p == null &&  q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val;
    }

    public boolean isSameTreeUsingQueue(TreeNode p, TreeNode q){
        ArrayDeque<TreeNode> pQ = new ArrayDeque<>();
        ArrayDeque<TreeNode> qQ = new ArrayDeque<>();
        if(!check(p, q)) return false;
        if(p != null){
            pQ.add(p);
            qQ.add(q);
        }

        while(!pQ.isEmpty()){
            TreeNode pNode = pQ.removeLast();
            TreeNode qNode = qQ.removeLast();
            if(!check(pNode, qNode)) return false;
            if(!check(pNode.left, qNode.left)) return false;
            if(pNode.left != null){
                pQ.add(pNode.left);
                qQ.add(qNode.left);
            }
            if(!check(pNode.right, qNode.right)) return false;
            if(pNode.right != null){
                pQ.add(pNode.right);
                qQ.add(qNode.right);
            }
        }
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);

        while(!pStack.isEmpty() || !qStack.isEmpty()){
            TreeNode pNode = pStack.isEmpty() ? null : pStack.pop();
            TreeNode qNode = qStack.isEmpty() ? null : qStack.pop();
            if(null != pNode && null !=qNode){
                if(pNode.val != qNode.val){
                    return false;
                }
                pStack.push(pNode.right);
                pStack.push(pNode.left);
                qStack.push(qNode.right);
                qStack.push(qNode.left);
            }else if (null == pNode && null != qNode){
                return false;
            }else if(null != pNode){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] array = new int[100];
        Random random = new Random();
        for(int i=0;i<100;i++){
            array[i] = random.nextInt(100-1)+1;
        }


        TreeNode n1 = TreeNode.buildBinaryTree(array);
        TreeNode n2 = TreeNode.buildBinaryTree(array);

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(n1, n2));
        System.out.println(sameTree.isSameTreeRecursion(n1, n2));
        System.out.println(sameTree.isSameTreeUsingQueue(n1, n2));


        int[] array2 = new int[100];
        Random random2 = new Random();
        for(int i=0;i<100;i++){
            array2[i] = random2.nextInt(100-1)+1;
        }

        TreeNode n3 = TreeNode.buildBinaryTree(array);
        TreeNode n4 = TreeNode.buildBinaryTree(array2);

        System.out.println(sameTree.isSameTree(n3, n4));
        System.out.println(sameTree.isSameTreeRecursion(n3, n4));
        System.out.println(sameTree.isSameTreeUsingQueue(n3, n4));
    }

}
