package leetcode.string.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */
public class PartitionLabels {

    Map<Character, List<Integer>> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    private boolean isGoodPartition(int i, int j, String S){
        for(int k=i;k<=j;k++){
            char c = S.charAt(k);
            List<Integer> lst = map.get(c);
            if(lst.get(0) <i || lst.get(lst.size()-1)>j) return false;
        }
        return true;

    }

    private void partition(String S, int start, int end){
        if(end == S.length()){
            return;
        }
        if(isGoodPartition(start, end, S)){
            result.add(end - start + 1);
            partition(S, end+1, end+1);
        }else{
            partition(S, start, end+1);
        }
    }

    public List<Integer> partitionLabels(String S) {
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            List<Integer> indices = map.getOrDefault(c, new ArrayList<Integer>());
            indices.add(i);
            map.put(c, indices);
        }
        partition(S, 0, 0);
        return result;
    }

    public List<Integer> partitionLabelsApproach2(String S){
        int[] last = new int[26];
        for(int i=0;i<S.length();i++){
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int j=0, anchor = 0;
        for(int i=0;i<S.length();i++){
            j = Math.max(last[S.charAt(i) - 'a'], j);
            if(j == i){
                result.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return result;
    }


    public static void main(String[] args){
        String s = "abc";
        int a = s.indexOf("a");
        int b = s.indexOf("b");
        int c = s.indexOf("c");
        System.out.println(a);
        PartitionLabels p = new PartitionLabels();
        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij")); // Created solution myself.... approach 2 is simpler version of same idea
        System.out.println(p.partitionLabelsApproach2("ababcbacadefegdehijhklij"));
    }
}
