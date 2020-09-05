package leetcode.graph.medium;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    List<List<Integer>> adj;

    private void addEdge(int i, int j){
        adj.get(i).add(j);
    }

    private void buildGraph(int[][] prerequisites, int numCourses){
        adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite:prerequisites){
            addEdge(prerequisite[0], prerequisite[1]);
        }
    }

    private boolean isCyclic(int s, boolean[] restack, boolean[] visited){
        if(restack[s]){
            return true;
        }
        if(visited[s]){
            return false;
        }
        restack[s] = true;
        visited[s] = true;
        for(int e:adj.get(s)){
            if(isCyclic(e, restack, visited)){
                return false;
            }
        }
        restack[s] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(prerequisites, numCourses);
        boolean[] visited = new boolean[numCourses];
        boolean[] restack = new boolean[numCourses];
        int i=0;
        while(i<numCourses){
            if(isCyclic(i, restack, visited)){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args){
        int[][] i = {{1,0}, {2,0}};
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(3, i));
    }

}
