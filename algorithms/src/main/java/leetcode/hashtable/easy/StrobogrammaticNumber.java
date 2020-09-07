package leetcode.hashtable.easy;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 * Example 4:
 *
 * Input: num = "1"
 * Output: true
 */
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        char[] arr = num.toCharArray();
        char[] ch = {'0','1','$','$','$', '$','9','$','8','6'};
        for(int l=0,r=arr.length-1;l<=r;l++,r--){
            if(ch[arr[l] - '0'] == '$' || ch[arr[l]-'0'] != arr[r]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        StrobogrammaticNumber sb = new StrobogrammaticNumber();
        System.out.println(sb.isStrobogrammatic("69"));
        System.out.println(sb.isStrobogrammatic("88"));
        System.out.println(sb.isStrobogrammatic("2"));

    }
}
