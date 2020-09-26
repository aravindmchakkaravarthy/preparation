package leetcode.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a directed acyclic graph of N nodes. Find all possible paths from node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 *
 * Constraints:
 *
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourceToTarget {

    private void helper(List<Integer> path, List<List<Integer>> result, int[][] graph, int curr){
        if(curr == graph.length-1){
            result.add(new ArrayList<>(path));
            return;
        }
        if(graph[curr].length==0) return;//nowhere to go

        for(int x:graph[curr]){
            path.add(x);
            helper(path, result, graph, x);
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        helper(new ArrayList<>(Arrays.asList(0)), result, graph, 0);
        return result;
    }

    public static void main(String[] args){
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        AllPathsFromSourceToTarget a = new AllPathsFromSourceToTarget();
        System.out.println(a.allPathsSourceTarget(graph));
    }
}
