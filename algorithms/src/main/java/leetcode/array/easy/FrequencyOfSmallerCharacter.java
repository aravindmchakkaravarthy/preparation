package leetcode.array.easy;

/**
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 *
 *
 *
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 */
public class FrequencyOfSmallerCharacter {

    public static int frequency(String word) {
        int currentC = 0;
        int currentF = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ((int) c < currentC || currentC == 0) {
                currentC = (int) c;
                currentF = 1;
            } else if ((int) c == currentC) {
                currentF++;
            }
        }
        return currentF;
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryF = new int[queries.length];
        int[] wordsF = new int[words.length];
        for (int i = 0; i < queries.length; i++) queryF[i] = frequency(queries[i]);
        for (int i = 0; i < words.length; i++) wordsF[i] = frequency(words[i]);
        int[] ans = new int[queries.length];
        int i = 0;
        for (int qf : queryF) {
            int cf = 0;
            for (int wf : wordsF) {
                if (qf < wf) {
                    cf++;
                }
            }
            ans[i++] = cf;
        }
        PrintUtil.print(queryF);
        PrintUtil.print(wordsF);
        return ans;
    }

    public static void main(String[] args) {
        String[] queries = {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
        String[] words = {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
        int[] ans = numSmallerByFrequency(queries, words);
        PrintUtil.print(ans);
    }
}
