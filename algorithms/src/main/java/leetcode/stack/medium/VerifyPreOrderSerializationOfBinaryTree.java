package leetcode.stack.medium;

import util.PrintUtil;

import java.util.*;

public class VerifyPreOrderSerializationOfBinaryTree {

    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int[] visited = new int[nodes.length];
        Arrays.fill(visited, 0);
        int i=0;
        while(i>=0){
            i = findLeftMost(nodes, 0);
            if(i<0 || i>=nodes.length ){
                break;
            }
            visited[i] = 1;
            visited[i-1] = 1;
            i = i +1;
            if(nodes[i].equals("#")){
                visited[i] = 1;
                while(visited[i] == 1){
                    i--;
                }
            }
        }
        PrintUtil.print(visited);
        return false;
    }

    private int findLeftMost(String[] nodes, int index){
        for(int i=index;i<nodes.length;i++){
            if(nodes[i].equals("#")){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Queue<Integer> q = new ArrayDeque<>();


        String testString = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        VerifyPreOrderSerializationOfBinaryTree vpos = new VerifyPreOrderSerializationOfBinaryTree();
        System.out.println(vpos.isValidSerialization(testString));
    }
}
