package leetcode.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {

        Set<Character> set = new HashSet<>();
        char[] jchar = J.toCharArray();
        for(char jc:jchar){
            set.add(jc);
        }
        int count = 0;
        char[] schar = S.toCharArray();
        for(char sc:schar){
            if (set.contains(sc)) count++;
        }
        return count;
    }

    public static void main(String[] args){
        JewelsAndStones jAndS = new JewelsAndStones();
        System.out.println(jAndS.numJewelsInStones("aA", "aAAbb"));
    }
}
