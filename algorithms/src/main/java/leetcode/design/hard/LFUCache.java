package leetcode.design.hard;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node{
        int key;
        int val;
        int frequency;
        Node prev;
        Node next;
        Node(int key, int value, int frequency){
            this.key = key;
            this.val = value;
            this.frequency = frequency;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int size;
    Map<Integer, Node> map;
    Map<Integer, Node> frequency;

    LFUCache(int capacity){
        this.capacity = capacity;
        size = 0;
        head = null;
        tail = null;
        map = new HashMap<>();
        frequency = new HashMap<>();
    }

    public void evict(Node node){
        if(node == head && node == tail){
            head = null;
            tail = null;
        }else if(node == head){
            head = head.next;
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

    public void addNode(Node node, Node next){
        if(next == null){
            if(head == null){
                head = node;
            }else{
                node.prev = tail;
            }
            tail = node;
        }
        else{
            node.prev = next.prev;
            node.next = next.next;
            if(next == head){
                head = node;
            }
        }
        size++;
    }

    public int get(int key){
        return 0;

    }

    public Node getNext(int frequency){
        while(frequency >=0){
            if(this.frequency.containsKey(frequency)){
                return this.frequency.get(frequency);
            }
            frequency--;
        }
        return null;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            map.get(key);
        }
        Node node = new Node(key, val, 0);
        Node next = getNext(0);
        addNode(node,next);
        map.put(key, node);
        frequency.put(0, node);
    }

    public static void main(String[] args){
        Map<int[], String> test;
        // Node will contain val, count, prev & next;
        // map will contain key and node;
        // map will contain key and frequency - if there are more than one key frequency then latest used node will be replaced;
        // On Put - create a node with zero frequency - and add it before first zero
        // On get - retrieve the node from the map with key and node. get the node with the frequency + 1 and insert it before that.
    }
}
