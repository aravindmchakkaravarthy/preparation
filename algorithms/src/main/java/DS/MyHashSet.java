package DS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 * Example:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 * Note:
 *
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
public class MyHashSet {

    List<Integer>[] lists;

    /** Initialize your data structure here. */
    public MyHashSet() {
        lists = new ArrayList[1000];
    }


    private int getHash(int x){
        return x % 1000;
    }

    public void add(int key) {
        List<Integer> bucket = lists[getHash(key)];
        if(null == bucket){
            bucket = new ArrayList<>();
        }
        if(!bucket.contains(key)){
            bucket.add(key);
        }
        lists[getHash(key)] = bucket;
    }

    public void remove(int key) {
        List<Integer> bucket = lists[getHash(key)];
        if(null != bucket){
            bucket.remove(Integer.valueOf(key));
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        List<Integer> bucket = lists[getHash(key)];
        return null != bucket && bucket.contains(key);
    }

    public static void main(String[] args){


        MyHashSet hashSet = new MyHashSet();

        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));   // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}
