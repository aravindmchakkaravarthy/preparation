package DS;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

    static class TrieNode{
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            Map<Character, TrieNode> children = curr.children;
            char c = word.charAt(i);
            if(!children.containsKey(c)){
                TrieNode child = new TrieNode();
                children.put(c, child);
            }
            curr = children.get(c);
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trie = getMatchingTrie(word);
        return (trie != null) && trie.isWord;
    }

    public TrieNode getMatchingTrie(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            Map<Character, TrieNode> children = curr.children;
            if(!children.containsKey(c)){
                return null;
            }else{
                curr = children.get(c);
            }
        }
        return curr;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getMatchingTrie(prefix) != null;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
