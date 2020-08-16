package leetcode.queue.medium;

import util.PrintUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {
    private static class Pair{
        int i;
        int j;
        Pair(int x, int y){
            i = x;
            j = y;
        }
        public int getI(){
            return i;
        }
        public int getJ(){
            return j;
        }
    }

    private static List<Pair> findNeighbor(int i, int j, char[][] matrix){
        List<Pair> pairs = new ArrayList<>();
        //Add row neighbors;
        int cS = j-1, cE = j+1;
        char[] row = matrix[i];
        while(cS<=cE && cS < row.length){
            if(cS>=0 && cS != j){
                pairs.add(new Pair(i, cS));
            }
            cS++;
        }
        int rS = i-1, rE = i+1;
        while(rS<=rE && rS < matrix.length){
            if(rS>=0 && rS != i){
                pairs.add(new Pair(rS, j));
            }
            rS++;
        }
        return pairs;
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int x = grid[i][j];
                if(x == '1'){
                    Queue<Pair> queue = new ArrayDeque<>();
                    queue.add(new Pair(i, j));
                    while(!queue.isEmpty()){
                        Pair pair = queue.poll();
                        if(grid[pair.i][pair.j] != '2'){
                            grid[pair.i][pair.j] = '2';
                            List<Pair> pairs = findNeighbor(pair.i, pair.j, grid);
                            for(Pair thisPair:pairs){
                                if(grid[thisPair.i][thisPair.j] == '1'){
                                    queue.add(new Pair(thisPair.i, thisPair.j));
                                }
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String args[]){
        char[][] matrix =
                {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                        {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                        {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                        {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                        {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        PrintUtil.print(matrix);
        System.out.println(numIslands(matrix));
    }
}
