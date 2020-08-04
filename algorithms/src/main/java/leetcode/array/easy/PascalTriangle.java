package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int line = 0; line < numRows; line++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i <= line; i++) {
                if (i == 0 || line == i) {
                    list.add(1);
                } else {

                    List<Integer> prevList = lists.get(line - 1);
                    list.add(prevList.get(i) + prevList.get(i - 1));
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String args[]) {
        System.out.println(generate(6));
    }
}
