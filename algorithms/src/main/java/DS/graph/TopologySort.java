package DS.graph;

import java.util.*;

public class TopologySort {

    public Set<Integer> topologicalSort(AbstractGraph g){
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<g.n;i++){
            inDegreeMap.put(i, g.getInDegree(i));
            if(inDegreeMap.get(i) == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int i = queue.poll();
            set.add(i);
            for(int x: g.getAdjacentVertices(i)){
                inDegreeMap.put(x, inDegreeMap.get(x)-1);
                if(inDegreeMap.get(x) == 0){
                    queue.add(x);
                }
            }
        }
        if(set.size() != g.n){
            set.clear();
        }
        return set;
    }

    public static void main(String[] args){
        AbstractGraph g = new AdjacencyMatrix(9, true);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,7);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(1,5);
        g.addEdge(5,6);
        g.addEdge(3,6);
        g.addEdge(3,4);
        g.addEdge(6,8);

        TopologySort sort = new TopologySort();
        System.out.println(sort.topologicalSort(g));
    }
}
