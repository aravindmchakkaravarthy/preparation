package DS.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdjacencySet extends AbstractGraph{

    static class Tuple {
        int id;
        int weight;
        Tuple(int id, int weight){
            this.id = id;
            this.weight = weight;
        }
        public int getId(){
            return id;
        }
    }

    Set<Tuple>[] adj;

    AdjacencySet(int size){
        super(size);
        adj = new Set[n];
        for(int i=0;i<n;i++){
            adj[i] = new HashSet<>();
        }
    }

    AdjacencySet(int size, boolean isDirected){
        super(size);
        adj = new Set[n];
        for(int i=0;i<n;i++){
            adj[i] = new HashSet<>();
        }
        directed = isDirected;
    }


    @Override
    public void addEdge(int i, int j) {
        addEdge(i,j,1);

    }

    @Override
    public void addEdge(int i, int j, int weight) {
        adj[i].add(new Tuple(j, weight));
        if(!directed){
            adj[j].add(new Tuple(i, weight));
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int i) {
        return adj[i].stream().map(Tuple::getId).collect(Collectors.toList());
    }

    @Override
    public int getInDegree(int i) {
        int count = 0;

        for(int j=0;j<n;j++){
            if(adj[j].contains(i)){
                count++;
            }
        }
        return count;
    }

    @Override
    public int getEdgeWeight(int i, int j) {
        Tuple t = adj[i].stream().filter(a -> a.id == j).findFirst().orElse(null);
        return t.weight;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(Tuple t: adj[i]){
                sb.append(i).append("->").append(t.id).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        AdjacencySet g = new AdjacencySet(4, true);
        g.addEdge(0,1, 5);
        g.addEdge(0,2, 10);
        g.addEdge(2,3, 20);

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
