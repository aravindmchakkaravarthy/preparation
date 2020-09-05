package leetcode.graph.medium;

import util.PrintUtil;

import java.util.*;

/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        int[] in = new int[numCourses];
        for(int[] x:prerequisites){
            int dest = x[0];
            int src = x[1];
            Set<Integer> set = adjList.getOrDefault(src, new HashSet<>());
            set.add(dest);
            adjList.put(src, set);
            in[dest] += 1;
        }


        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(in[i] == 0) q.add(i);
        }
        int size = 0;
        int[] result = new int[numCourses];
        while(!q.isEmpty()){
            int i = q.poll();
            result[size++] = i;
            if(adjList.containsKey(i)){
                for(int x: adjList.get(i)){
                    in[x] -= 1;
                    if(in[x] == 0){
                        q.add(x);
                    }
                }
            }
        }
        return size == numCourses ? result : new int[0];
    }

    public static void main(String[] args){
        CourseScheduleII cs = new CourseScheduleII();
        PrintUtil.print(cs.findOrder(2, new int[][]{{1,0}}));
    }
}
