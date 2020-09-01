package leetcode.trie.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * You should design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) adds word to the data structure, it can be matched later.
 * bool search(word) returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 500
 * word in addWord consists lower-case English letters.
 * word in search consist of  '.' or lower-case English letters.
 * At most 50000 calls will be made to addWord and search
 */
public class WordDictionary {

    class Trie{
        Map<Character, Trie> children = new HashMap<>();
        boolean isWord;
    }

    Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie curr = root;
        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c, new Trie());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word, Trie root){
        Trie curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if( c== '.'){
                String sub = word.substring(i+1, word.length());
                for(Trie node: curr.children.values()){
                    if(search(sub, node)){
                        return true;
                    }
                }
                return false;
            }
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            }else{
                return false;
            }
        }
        return curr != null && curr.isWord;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    public static void main(String[] args){

        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad")); // Returns false;
        System.out.println(wd.search("bad")); // returns true;
        System.out.println(wd.search(".ad")); // returns true;
        System.out.println(wd.search("b..")); // returns true;
        System.out.println(wd.search("b..t"));
    }
}
