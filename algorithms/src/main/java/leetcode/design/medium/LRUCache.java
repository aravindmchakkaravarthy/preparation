package leetcode.design.medium;

import java.util.*;

public class LRUCache {

    Queue<Integer> queue = new LinkedList<>();
    HashMap<Integer, Integer> cache = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Queue<Integer> temp = new LinkedList<>();
        while(!queue.isEmpty()){
            if(queue.peek() == key){
                queue.poll();
            }else{
                temp.add(queue.poll());
            }
        }
        queue = temp;
        queue.add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Queue<Integer> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                if(queue.peek() == key){
                    queue.poll();
                }else{
                    temp.add(queue.poll());
                }
            }
            queue = temp;
        }
        if(queue.size()== capacity){
            cache.remove(queue.poll());
        }
        queue.add(key);
        cache.put(key, value);
    }

    public static void main(String[] args){

        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

        //TODO this is not a optimal implementation.
        // Getting an item from cache takes O(N)
        // Replacing an item in cache takes O(N)
        // Putting an item in cache takes O(1)


    }
}
