package leetcode.string.medium;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyNumbers {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] p = new int[m + n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int p1 = i + j, p2 = i + j + 1;
                int mul = (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
                int n3 = p[p2] + mul;
                p[p2] = n3 % 10;
                p[p1] +=  n3 / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int ch:p)if(ch != 0 || sb.length() !=0)sb.append(ch);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args){
        MultiplyNumbers mn = new MultiplyNumbers();
        System.out.println(mn.multiply("123", "234"));//returns 28782
    }
}
