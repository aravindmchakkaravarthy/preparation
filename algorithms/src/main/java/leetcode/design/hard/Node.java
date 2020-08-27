package leetcode.design.hard;

public class Node {
    int key;
    int val;
    int freq;
    Node next;
    Node prev;

    Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }

    Node() {

    }
}
