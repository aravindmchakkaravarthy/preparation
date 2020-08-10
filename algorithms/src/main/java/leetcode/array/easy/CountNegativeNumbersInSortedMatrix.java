package leetcode.array.easy;

/**
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
 *
 * Return the number of negative numbers in grid.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * Example 3:
 *
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * Example 4:
 *
 * Input: grid = [[-1]]
 * Output: 1
 */
public class CountNegativeNumbersInSortedMatrix {

    public static int countNegatives(int[][] grid) {
        int countOfNegative = 0;
        for(int[] element:grid){
            for(int j=element.length-1;j>=0;j--){
                if(element[j]>=0){
                    break;
                }
                countOfNegative++;
            }
        }
        return countOfNegative;
    }

    public static void main(String[] args){
        int[][] x = {{4,3,2,-1},{3,2,1,-1}, {1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(x));
    }
}
