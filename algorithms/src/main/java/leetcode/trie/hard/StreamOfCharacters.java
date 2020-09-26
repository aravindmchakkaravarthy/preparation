package leetcode.trie.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Implement the StreamChecker class as follows:
 *
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 *
 *
 * Example:
 *
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 *
 *
 * Note:
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000
 */
public class StreamOfCharacters {

    class Trie{
        Map<Character, Trie> children = new HashMap<>();
        boolean word;
    }

    Trie root;

    Deque<Character> q = new ArrayDeque<>();

    public StreamOfCharacters(String[] words) {
        root = new Trie();
        for(String word:words){
            String w = new StringBuilder(word).reverse().toString();
            Trie curr = root;
            for(char c:w.toCharArray()){
                curr.children.putIfAbsent(c, new Trie());
                curr = curr.children.get(c);
            }
            curr.word = true;
        }
    }

    public boolean query(char letter) {
        q.addFirst(letter);
        Trie curr = root;
        for(char ch:q){
            if(curr.word){
                return true;
            }
            if(!curr.children.containsKey(ch)){
                return false;
            }else{
                curr = curr.children.get(ch);
            }
        }

        return curr.word;
    }

    public static void main(String[] args){
        String[] words = {"cd","f","kl"};
        StreamOfCharacters sc = new StreamOfCharacters(words);
        System.out.println(sc.query('a'));
        System.out.println(sc.query('b'));
        System.out.println(sc.query('c'));
        System.out.println(sc.query('d'));
        System.out.println(sc.query('f'));
    }
}
