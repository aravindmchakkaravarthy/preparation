package DS.graph;

import java.util.*;

public class ShortestWeightedDistance {

    class Tuple {
        int distance;
        int node;
        Tuple(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }

    public Map<Integer, Tuple> getDistanceTable(AbstractGraph g, int s, int d){
        Map<Integer, Tuple> distanceTable = new HashMap<>();
        for(int i=0;i<g.n;i++){
            distanceTable.put(i, null);
        }
        distanceTable.put(s, new Tuple(0,  s));
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> distanceTable.get(a).distance));
        q.add(s);
        while(!q.isEmpty()){
            int c = q.poll();
            Tuple t = distanceTable.get(c);
            for(int x:g.getAdjacentVertices(c)){
                int distance = t.distance + g.getEdgeWeight(c,x);
                if(distanceTable.get(x) == null || distanceTable.get(x).distance>distance){
                    distanceTable.put(x, new Tuple(distance, c));
                    q.add(x);
                }
            }
        }

        return distanceTable;
    }

    public List<Integer> getShortestPath(AbstractGraph g, int s, int d){
        Map<Integer, Tuple> distanceTable = getDistanceTable(g, s, d);
        LinkedList<Integer> list = new LinkedList<>();
        Integer prev = d;
        while(prev != null && prev != s){
            list.addFirst(prev);
            Tuple t = distanceTable.get(prev);
            prev = t != null ? t.node:null;
        }
        if(prev == null){
            list.clear();
        }else{
            list.addFirst(s);
        }
        return list;
    }

    public static void main(String[] args){
        AbstractGraph g = new AdjacencySet(8, false);
        g.addEdge(0,1, 1);
        g.addEdge(1,2, 2);
        g.addEdge(1,3, 6);
        g.addEdge(2,3, 2);
        g.addEdge(1,4, 3);
        g.addEdge(3,5,1);
        g.addEdge(5,4,3);
        g.addEdge(3,6, 1);
        g.addEdge(6,7, 1);
        g.addEdge(0,7,8);

        ShortestWeightedDistance sd = new ShortestWeightedDistance();
        System.out.println(sd.getShortestPath(g, 0,6));
        System.out.println(sd.getShortestPath(g, 4,7));
        System.out.println(sd.getShortestPath(g, 7,0));
    }
}
