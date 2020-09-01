package leetcode.trie.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
class MapSum {

    class Trie{
        int sum;
        Map<Character, Trie> children = new HashMap<>();
        Trie(int sum){
            this.sum = sum;
        }
        boolean isEnd;
    }

    Trie root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Trie(0);
    }

    public void insert(String key, int val) {
        Trie curr = root;
        Trie existing = getWord(key);
        int newVal = existing != null && existing.isEnd ? val - existing.sum : val;
        for(int i=0;i<key.length();i++){
            Map<Character, Trie> children = curr.children;
            Character c = key.charAt(i);
            if(!children.containsKey(c)){
                children.put(c, new Trie(0));
            }
            curr.sum += newVal;
            curr = children.get(c);
        }
        curr.sum = val;
        curr.isEnd = true;
    }

    public Trie getWord(String word){
        Trie curr = root;
        for(int i=0;i<word.length();i++) {
            Map<Character, Trie> children = curr.children;
            Character c = word.charAt(i);
            if (!children.containsKey(c)) {
                return null;
            } else {
                curr = children.get(c);
            }
        }
        return curr;
    }

    public int sum(String prefix) {
        Trie curr = root;
        int sum = curr.sum;
        for(int i=0;i<prefix.length();i++) {
            Map<Character, Trie> children = curr.children;
            Character c = prefix.charAt(i);
            if (children.containsKey(c)) {
                curr = children.get(c);
                sum = curr.sum;
            } else {
                return 0;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        MapSum ms = new MapSum();
        ms.insert("aa", 3);
        System.out.println(ms.sum("a"));
        ms.insert("aa", 2);
        System.out.println(ms.sum("a"));
    }
}
