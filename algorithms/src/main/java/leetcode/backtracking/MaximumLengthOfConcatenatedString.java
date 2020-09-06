package leetcode.backtracking;

import java.util.Arrays;
import java.util.List;

public class MaximumLengthOfConcatenatedString {

    private boolean isUniqueCharacters(String S){
        boolean[] set = new boolean[26];
        for(Character c:S.toCharArray()){
            if(set[c-'a']) return false;
            set[c-'a'] = true;
        }
        return true;
    }

    private void helper(String path, int start, int[] max, List<String> arr){
        if(!isUniqueCharacters(path)) return;
        max[0] = Math.max(max[0], path.length());
        for(int i=start;i<arr.size();i++){
            helper(path+arr.get(i), i+1, max, arr);
        }

    }

    public int maxLength(List<String> arr) {
        int[] max = new int[1];

        helper("", 0, max, arr);
        return max[0];
    }

    public static void main(String[] args){

        List<String> n = Arrays.asList("un","iq","ue");
        MaximumLengthOfConcatenatedString ms = new MaximumLengthOfConcatenatedString();
        System.out.println(ms.maxLength(n));
    }
}
