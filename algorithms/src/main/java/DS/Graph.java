package DS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    int V;

    List<LinkedList<Integer>> adj;

    public Graph(int v){
        V = v;
        adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int i, int j){
        adj.get(i).add(j);
    }

    public int noOfVertices(){
        return V;
    }

    public LinkedList<Integer> getEdges(int i){
        return adj.get(i);
    }
}
