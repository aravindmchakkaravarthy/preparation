package leetcode.stack.medium;


import util.PrintUtil;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i]>=T[stack.peek()]) stack.pop();
            result[i] = stack.isEmpty() ? 0: stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(6/-32);
        DailyTemperatures dt = new DailyTemperatures();
        PrintUtil.print(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));//brute force
        PrintUtil.print(dt.dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));//Using stack

    }
}
