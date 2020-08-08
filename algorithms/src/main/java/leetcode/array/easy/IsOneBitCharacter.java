package leetcode.array.easy;

import java.sql.SQLOutput;

/**
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 *
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 *
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 */
public class IsOneBitCharacter {

    public static boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1 ) return true;
        if(bits.length >= 2 && bits[bits.length - 2] == 0) return true;
        boolean isOneBitCharacter;
        int i = 0;
        do{
            if(bits[i] == 0) {
                isOneBitCharacter = true;
            }else{
                isOneBitCharacter = false;
                i++;
            }
            i++;
        }while(i<bits.length);
        return isOneBitCharacter;
    }

    public static void main(String args[]){
        int[] nums = {1,1,1,0};
        System.out.println(isOneBitCharacter(nums));
    }
}
