package DS.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix extends AbstractGraph {

    int[][] adj;

    AdjacencyMatrix(int size){
        super(size);
        adj = new int[size][size];
    }

    AdjacencyMatrix(int size, boolean isDirected){
        super(size, isDirected);
        adj = new int[size][size];
        directed = isDirected;
    }

    public void addEdge(int i, int j){
        addEdge(i, j, 1);
    }

    @Override
    public void addEdge(int i, int j, int weight) {
        adj[i][j] = weight;
        if(!directed){
            adj[j][i] = weight;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int i) {
        List<Integer> result = new ArrayList<>();
        for(int j=0;j<adj[i].length;j++){
            if(adj[i][j] != 0){
                result.add(j);
            }
        }
        return result;
    }

    @Override
    public int getInDegree(int i) {
        int count = 0;
        for(int[] x:adj){
            if(x[i] != 0){
                count++;
            }
        }
        return count;
    }

    @Override
    public int getEdgeWeight(int i, int j) {
        return adj[i][j];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj[i][j] != 0)
                sb.append(i).append("->").append(j).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        AdjacencyMatrix g = new AdjacencyMatrix(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(2,3);

        for(int i=0;i<4;i++){
            System.out.println("Adjacent to:" + i+ g.getAdjacentVertices(i));
        }

        for(int i=0;i<4;i++){
            System.out.println("Indegree:" + i+ g.getInDegree(i));
        }

        for(int i=0;i<4;i++){
            for(int j: g.getAdjacentVertices(i)){
                System.out.println("Edge Weight:" + i+","+j+":"+ g.getEdgeWeight(i,j));
            }
        }
        System.out.println(g);
    }
}
