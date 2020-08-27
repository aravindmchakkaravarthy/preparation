package leetcode.hashtable.medium;

import util.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    private String getKey(int[] key){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<key.length;i++){
            if(key[i]>0){
                int count = key[i];
                while(count>0){
                    sb.append((char)i+'a');
                    count--;
                }
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] key = new int[27];
            for(int i=0;i<str.length();i++){
                Character c = str.charAt(i);
                key[c-'a'] += 1;
            }
            String keyString = getKey(key);
            if(map.containsKey(keyString)){
                map.get(keyString).add(str);
            }else{
                List<String> res = new ArrayList<>();
                res.add(str);
                map.put(keyString, res);
            }
        }
        return new ArrayList<>(map.values());

    }

    public static void main(String[] args){

        String[] input = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(input));

    }
}
