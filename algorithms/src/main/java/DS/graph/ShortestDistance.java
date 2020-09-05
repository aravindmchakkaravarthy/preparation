package DS.graph;

import java.util.*;

public class ShortestDistance {

    static class Tuple{
        Integer distance;
        Integer precedingNode;
        Tuple(Integer dist, Integer node){
            this.distance = dist;
            this.precedingNode = node;
        }
    }

    public Map<Integer, Tuple> distanceTable(AbstractGraph g, int source){
        Map<Integer, Tuple> distanceTable = new HashMap<>();
        for(int i=0;i<g.n;i++){
            distanceTable.put(i, new Tuple(null,null));
        }
        distanceTable.put(source, new Tuple(0, source));
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        while(!q.isEmpty()){
            int c = q.poll();
            int distance = distanceTable.get(c).distance;
            for(int x: g.getAdjacentVertices(c)){
                Tuple t = distanceTable.get(x);
                if(t.distance == null){
                    distanceTable.put(x, new Tuple(distance+1, c));
                    q.add(x);
                }
            }
        }
        return distanceTable;
    }

    public List<Integer> getShortestPath(AbstractGraph g, int s, int d){
        Map<Integer, Tuple> distanceTable = distanceTable(g, s);
        LinkedList<Integer> shortestPath = new LinkedList<>();
        if(distanceTable.containsKey(d)){
            Integer prev = d;
            while(prev != null && prev != s){
                shortestPath.addFirst(prev);
                Tuple t = distanceTable.get(prev);
                prev = t.precedingNode;
            }
            if(prev == null){
                shortestPath.clear();
            }else {
                shortestPath.addFirst(s);
            }
        }
        return shortestPath;
    }

    public static void main(String[] args){
        AbstractGraph g = new AdjacencySet(8, true);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(1,4);
        g.addEdge(3,5);
        g.addEdge(5,4);
        g.addEdge(3,6);
        g.addEdge(6,7);
        g.addEdge(0,7);

        ShortestDistance sd = new ShortestDistance();
        System.out.println(sd.getShortestPath(g, 0,5));
        System.out.println(sd.getShortestPath(g, 0,6));
        System.out.println(sd.getShortestPath(g, 7,4));
    }
}
