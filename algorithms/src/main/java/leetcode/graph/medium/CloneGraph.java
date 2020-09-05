package leetcode.graph.medium;

import DS.Node;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.
 *
 * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * Example 4:
 *
 *
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 */
public class CloneGraph {

    private Node createNode(int val, Map<Integer, Node> map){
        if(map.containsKey(val)){
            return map.get(val);
        }else{
            Node node = new Node(val, new ArrayList<Node>());
            map.put(val, node);
            return node;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null)  return null;
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Node curr = null;
        while(!stack.isEmpty()){
            Node top = stack.pop();
            if(visited.contains(top.val)) continue;
            Node newNode = createNode(top.val, map);
            if(curr == null){
                curr = newNode;
            }

            visited.add(newNode.val);
            for(Node x: top.neighbors){
                Node neighbor = createNode(x.val, map);
                newNode.neighbors.add(neighbor);
                if(!visited.contains(neighbor.val)){
                    stack.push(x);
                }
            }
        }
        return curr;
    }

    public static void main(String[] args){
        Node one = new Node(1, new ArrayList<>());
        Node two = new Node(2, new ArrayList<>());
        Node four = new Node(3, new ArrayList<>());
        Node three = new Node(4, new ArrayList<>());

        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors.add(one);
        two.neighbors.add(three);

        three.neighbors.add(two);
        three.neighbors.add(four);

        four.neighbors.add(one);
        four.neighbors.add(three);

        CloneGraph cg = new CloneGraph();
        Node result = cg.cloneGraph(one);
        System.out.println(result);



    }
}
