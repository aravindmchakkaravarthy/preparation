package leetcode.graph.medium;

import util.PrintUtil;

import java.util.*;

public class NumberOfConnectedComponents {



    public int countComponentsPathCompression(int n, int[][] edges){
        int[] roots = new int[n];
        for(int i=0;i<roots.length;i++){
            roots[i] = i;
        }
        for(int[] edge:edges){

            int root1 = roots(roots, edge[0]);
            int root2 = roots(roots, edge[1]);
            if(root1 != root2){
                roots[root1] = root2;
                n--;
            }
        }
        return n;
    }

    private int roots(int[] roots, int id){
        while(roots[id] != id){
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }

    private void dfs(int i, Map<Integer, Set<Integer>> adj, Set<Integer> visited){
        for(int x:adj.get(i)){
            if(visited.add(x)){
                dfs(x, adj, visited);
            }
        }
    }

    public int countComponentsDFS(int n, int[][] edges){
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int[] edge:edges){
            Set<Integer> set = adj.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> destSet = adj.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[1]);
            destSet.add(edge[0]);
            adj.put(edge[0], set);
            adj.put(edge[1], destSet);
        }
        int size = 0;
        for(int i=0;i<n;i++){
            if(visited.add(i)){
                dfs(i, adj, visited);
                size++;
            }
        }
        return size;
    }

    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0) return n;
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for(int[] edge:edges){
            Set<Integer> set = adj.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> destSet = adj.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[1]);
            destSet.add(edge[0]);
            adj.put(edge[0], set);
            adj.put(edge[1], destSet);
        }
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int size = 1;
        while(!q.isEmpty()){
            int c = q.poll();
            visited[c] = true;
            if(adj.containsKey(c)){
                Set<Integer> neighbors = adj.get(c);
                for(int x:neighbors){
                    if(!visited[x]){
                        q.offer(x);
                    }
                }
            }

            if(q.isEmpty()){
                for(int i=0;i<visited.length;i++){
                    if(!visited[i]){
                        q.offer(i);
                        size++;
                        break;
                    }
                }
            }
        }
        return size;
    }

    public static void main(String args[]){
        int[][] arr = {{0, 1}, {1, 2}, {3, 4}};
        int[][] input2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] input3 = {{0,1},{0,2},{1,2}};
        NumberOfConnectedComponents n = new NumberOfConnectedComponents();
        System.out.println(n.countComponents(5, arr));
        System.out.println(n.countComponents(5, input2));
        System.out.println(n.countComponents(3, input3));

        System.out.println(n.countComponentsDFS(5, arr));
        System.out.println(n.countComponentsDFS(5, input2));
        System.out.println(n.countComponentsDFS(3, input3));

        System.out.println(n.countComponentsPathCompression(5, arr)); //TODO very interesting path compression approach
        System.out.println(n.countComponentsPathCompression(5, input2));
        System.out.println(n.countComponentsPathCompression(3, input3));
    }
}
