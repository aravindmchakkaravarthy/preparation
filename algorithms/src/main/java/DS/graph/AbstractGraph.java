package DS.graph;

import java.util.List;

public abstract class AbstractGraph {

    int n;
    boolean directed = false;

    AbstractGraph(int size){
        n = size;
    }

    AbstractGraph(int size, boolean isDirected){
        n = size;
        directed = isDirected;
    }
    public abstract void addEdge(int i, int j);
    public abstract void addEdge(int i, int j, int weight);

    public abstract List<Integer> getAdjacentVertices(int i);

    public abstract int getInDegree(int i);

    public abstract int getEdgeWeight(int i, int j);
}
