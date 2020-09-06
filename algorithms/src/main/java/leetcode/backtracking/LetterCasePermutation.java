package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {

    private void helper(String c, int start, List<String> result, String orig){
        if(start == orig.length()){
            result.add(c);
        }else{
            char ch = orig.charAt(start);
            if(ch >= '0' && ch <= '9'){
                helper(c + String.valueOf(ch), start+1, result, orig);
            }else{
                helper(c + String.valueOf(ch).toUpperCase(), start+1, result, orig);
                helper(c + String.valueOf(ch).toLowerCase(), start+1, result, orig);
            }
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        helper("", 0, result, S);
        return result;
    }

    public List<String> letterCasePermutationBFS(String S){
        if(null == S ) return new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for(int i=0;i<S.length();i++){
            if(Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for(int j=0;j<size;j++){
                String c = queue.poll();
                char[] chs = c.toCharArray();
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        return new ArrayList<>(queue);

    }

    public static void main(String[] args){
    LetterCasePermutation lp = new LetterCasePermutation();
        System.out.println(lp.letterCasePermutation("zf2s"));
        System.out.println(lp.letterCasePermutationBFS("zf2s"));
    }
}
