package DS.graph;

import DS.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;

public class Traversal {

    private void bft(AbstractGraph g, int n){
        if(g.n==0) return;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[g.n];
        queue.add(n);
        while(!queue.isEmpty()){
            int i = queue.poll();
            if(visited[i])
                continue;
            visited[i] = true;
            System.out.print(i+"->");
            queue.addAll(g.getAdjacentVertices(i));
        }
    }

    private void dftUtil(AbstractGraph g, int i, boolean[] visited){
        if(visited[i]) return;
        visited[i] = true;
        System.out.print(i+"->");
        for(int e:g.getAdjacentVertices(i)){
            dftUtil(g, e, visited);
        }
    }

    private void dft(AbstractGraph g, int n){
        if(g.n==0 || n>= g.n) return;
        boolean[] visited = new boolean[g.n];
        dftUtil(g, n, visited);


    }

    public static void main(String[] args){
        AdjacencyMatrix g = new AdjacencyMatrix(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,7);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(1,5);
        g.addEdge(5,6);
        g.addEdge(6,3);
        g.addEdge(3,4);
        g.addEdge(6,8);

        Traversal t = new Traversal();
        t.bft(g, 0);
        System.out.println();

        t.dft(g, 0);

    }
}
