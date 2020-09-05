package leetcode.graph.medium;

import DS.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void bfs(Graph graph, int s){
        boolean[] visited = new boolean[graph.noOfVertices()];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + "->");
            LinkedList<Integer> e = graph.getEdges(curr);
            for (int n : e) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args){

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        BFS bfs = new BFS();
        bfs.bfs(g, 2);

    }


}
