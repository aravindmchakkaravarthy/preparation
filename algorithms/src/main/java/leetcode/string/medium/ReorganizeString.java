package leetcode.string.medium;

import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String S) {
        int[] chars = new int[26];
        for(char c:S.toCharArray()){
            chars[c-'a']++;
            if(chars[c-'a'] > (S.length()+1)/2) return "";
        }

        PriorityQueue<Multichar> pq = new PriorityQueue<>((a, b) -> b.count - a.count);

        for(int i=0;i<26;i++){
            if(chars[i] >0){
                pq.add(new Multichar(chars[i], (char)('a'+i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>=2){
            Multichar mc1 = pq.poll();
            Multichar mc2 = pq.poll();
            sb.append(mc1.character).append(mc2.character);
            if(--mc1.count > 0) pq.add(mc1);
            if(--mc2.count > 0) pq.add(mc2);
        }
        if(pq.size()==1) sb.append(pq.poll().character);

        return sb.toString();

    }

    class Multichar{
        char character;
        int count;
        Multichar(int count, char character){
            this.count = count;
            this.character = character;
        }
    }

    public static void main(String[] args){
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("aab"));
        System.out.println(rs.reorganizeString("aaab"));
    }
}
