package leetcode.graph.medium;

import DS.Graph;


public class DFS {

    private void helper(Graph graph, int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s + "->");
        for(int e:graph.getEdges(s)){
            if(!visited[e]){
                visited[e] = true;
                helper(graph, e, visited);
            }

        }

    }

    public void dfs(Graph graph,int s){
        boolean[] visited = new boolean[graph.noOfVertices()];
        boolean[] stack = new boolean[graph.noOfVertices()];
        helper(graph, s, visited);
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
        DFS dfs = new DFS();
        System.out.println();
        dfs.dfs(g, 2);
    }
}
