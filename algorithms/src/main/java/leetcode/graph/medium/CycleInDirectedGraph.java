package leetcode.graph.medium;

import DS.Graph;

public class CycleInDirectedGraph {

    private boolean isCyclic(Graph graph, int s, boolean[] restack, boolean[] visited){
        if(restack[s]){
            return true;
        }
        if(visited[s]){
            return false;
        }
        visited[s] = true;
        restack[s] = true;
        for(int e:graph.getEdges(s)){
            if(isCyclic(graph, e, restack, visited)){
                return true;
            }
        }
        restack[s] = false;
        return false;
    }

    public boolean isCyclic(Graph graph){
        boolean[] visited = new boolean[graph.noOfVertices()];
        boolean[] stack = new boolean[graph.noOfVertices()];
        for(int i=0;i<graph.noOfVertices();i++){
            if(isCyclic(graph, i, stack, visited)){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);



        CycleInDirectedGraph c = new CycleInDirectedGraph();
        System.out.println(c.isCyclic(g));
    }
}
