package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 */
public class PositionOfLargeGroups {

    public static List<List<Integer>> largeGroupPositions(String S) {
        int fp = 0, lp = 0;
        char x = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<S.length();i++){
            char y = S.charAt(i);
            if(x == y){
                lp = i;
            }else{
                if(lp-fp+1 >=3){
                    ArrayList<Integer> thisResult = new ArrayList<Integer>();
                    thisResult.add(fp);
                    thisResult.add(lp);
                    result.add(thisResult);
                }
                fp = i;
                lp = i;
                x = S.charAt(i);
            }
            if(i == S.length()-1 && (x==y) && (lp-fp+1>=3)){
                ArrayList<Integer> thisResult = new ArrayList<Integer>();
                thisResult.add(fp);
                thisResult.add(lp);
                result.add(thisResult);
            }
        }
        return result;
    }

    public static void main(String[] args){
        String s = "aaa";
        System.out.println(largeGroupPositions(s));
    }
}
