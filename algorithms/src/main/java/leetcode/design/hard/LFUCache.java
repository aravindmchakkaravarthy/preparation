package leetcode.design.hard;

import util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * LFUCache cache = new LFUCache( 2);
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LFUCache {
    class Node{
        int key, val, fre;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            fre = 1;
        }
    }

    class LList{
        Node head;
        Node tail;
        int size;
        LList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }


        void add(Node node){
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        Node removeLast(){
            if(size>0){
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    int size, capacity, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, LList> countMap;

    public LFUCache(int capacity){
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key){
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            update(node);
            return node.val;
        }
        return -1;
    }

    public void update(Node node){
        LList oldList = countMap.get(node.fre);
        oldList.remove(node);
        if(node.fre == min && oldList.size == 0) min++;
        node.fre++;
        LList newList = countMap.getOrDefault(node.fre, new LList());
        newList.add(node);
        countMap.put(node.fre, newList);
    }

    public void put(int key, int val){
        if(capacity == 0) return;
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = val;
            update(node);
        }else{

            Node node = new Node(key, val);
            if(size == capacity){
                LList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLast().key);
                size--;
            }
            min = 1;
            size++;
            nodeMap.put(key, node);
            LList list = countMap.getOrDefault(node.fre, new LList());
            list.add(node);
            countMap.put(node.fre, list);
        }
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

//        LFUCache cache = new LFUCache( 3    /* capacity */ );
//        cache.put(2,2);
//        cache.put(1,1);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        cache.put(3,3);
//        cache.put(4,4);
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(4));


        /**
         * Get Method
         *  1. If key is not present in the map return -1
         *  2. If Key is present
         *          retrieve the node from map
         *          add one frequency
         *          Find in frequency map of the same frequency or nearest high freqeuency
         *          Add it after that node.
         *          Update freqeuency map with this node and frequency
         *
         3. Put method
         if Key is present
         Delete the node from map and frequency
         If Key is not present
         Add new node with zero frequency
         Find in frequency map with zero freqeuency or nearest high frequency and add it after the node.
         Update frequency map with this node and frequency


         4. Method:
         Add frequency: just put in map
         Remove frequency: just remove from map. but see if next node is also same frequency
         Find frequency: this frequency or nearest high frequency
         AddNode: Add current node next to the given node; adjust head and tail accordingly.
         DeleteNode: Remove current node and connect previous with next. Adjust head and tail accordingly.
         *
         */
    }
}
