package leetcode.design.medium;

import DS.MyDoublyLinkedList;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 *         get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *         put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 *         The cache is initialized with a positive capacity.
 *
 *         Follow up:
 *         Could you do both operations in O(1) time complexity?
 *
 *         Example:
 *
 *         LRUCache cache = new LRUCache( 2);//capacity
 *
 *         cache.put(1, 1);
 *         cache.put(2, 2);
 *         cache.get(1);       // returns 1
 *         cache.put(3, 3);    // evicts key 2
 *         cache.get(2);       // returns -1 (not found)
 *         cache.put(4, 4);    // evicts key 1
 *         cache.get(1);       // returns -1 (not found)
 *         cache.get(3);       // returns 3
 *         cache.get(4);       // returns 4
 */
public class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value ){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = null;
        tail = null;
        map = new LinkedHashMap<>();
    }

    public void deleteNode(Node node){
        if(node == head && node == tail){
            head = null;
            tail = null;
        }else if (node == head){
            head = node.next;
            head.prev = null;
        }else if (node == tail){
            tail = node.prev;
            tail.next = null;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    public void addAtHead(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        addAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
        }
        if(size == capacity){
            map.remove(tail.key);
            deleteNode(tail);
        }
        Node node = new Node(key, value);
        addAtHead(node);
        map.put(key, node);
    }

    public static void main(String[] args){

        //          5,2,3,12,7,11,4,1,10,6
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10,13);
        lruCache.put(3,17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        System.out.println(lruCache.get(13));
        lruCache.put(2,19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5,25);
        System.out.println(lruCache.get(8));
        lruCache.put(9,22);
        lruCache.put(5,5);
        lruCache.put(1,30);
        System.out.println(lruCache.get(11));
        lruCache.put(9,12);
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(9));
        lruCache.put(4,30);
        lruCache.put(9,3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));
        System.out.println(lruCache.get(10));
        lruCache.put(6,14);
        lruCache.put(3,1);
        System.out.println(lruCache.get(3));
        lruCache.put(10,11);
        System.out.println(lruCache.get(8));
        lruCache.put(2,14);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(4));
        lruCache.put(11,4);
        lruCache.put(12,24);
        lruCache.put(5,18);
        System.out.println(lruCache.get(13));
        lruCache.put(7,23);
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(12));
        lruCache.put(3,27);
        lruCache.put(2,12);
        System.out.println(lruCache.get(5));
        lruCache.put(2,9);
        lruCache.put(13,4);
        lruCache.put(8,18);
        lruCache.put(1,7);
        System.out.println(lruCache.get(6));
        lruCache.put(9,29);
        lruCache.put(8,21);
        System.out.println(lruCache.get(5));
        lruCache.put(6,30);
        lruCache.put(1,12);
        System.out.println(lruCache.get(10));
        lruCache.put(4,15);
        lruCache.put(7,22);
        lruCache.put(11,26);
        lruCache.put(8,17);
        lruCache.put(9,29);
        System.out.println(lruCache.get(5));
        lruCache.put(3,4);
        lruCache.put(11,30);
        System.out.println(lruCache.get(12));
        lruCache.put(4,29);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(6));
        lruCache.put(3,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(10));
        lruCache.put(3,29);
        lruCache.put(10,28);
        lruCache.put(1,20);
        lruCache.put(11,13);
        System.out.println(lruCache.get(3));
        lruCache.put(3,12);
        lruCache.put(3,8);
        lruCache.put(10,9);
        lruCache.put(3,26);
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        lruCache.put(13,17);
        lruCache.put(2,27);
        lruCache.put(11,15);
        System.out.println(lruCache.get(12));
        lruCache.put(9,19);
        lruCache.put(2,15);
        lruCache.put(3,16);
        System.out.println(lruCache.get(1));
        lruCache.put(12,17);
        lruCache.put(9,1);
        lruCache.put(6,19);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(5));
        lruCache.put(8,1);
        lruCache.put(11,7);
        lruCache.put(5,2);
        lruCache.put(9,28);
        System.out.println(lruCache.get(1));
        lruCache.put(2,2);
        lruCache.put(7,4);
        lruCache.put(4,22);
        lruCache.put(7,24);
        lruCache.put(9,26);
        lruCache.put(13,28);
        lruCache.put(11,26);
    }
}
